package com.fluentcommerce.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fluentcommerce.commonv2.graphql.type.AttributeInput;
import com.fluentcommerce.model.attribute.Attribute;
import com.fluentretail.api.model.location.Address;
import com.fluentretail.rubix.event.Event;
import com.fluentretail.rubix.exceptions.RubixException;
import com.fluentretail.rubix.v2.context.Context;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Method;
import java.util.*;
import java.util.stream.Collectors;

import static com.fluentcommerce.util.Constants.ErrorCode.ERROR_CODE_400;

@Slf4j
public class AttributeUtils {

    private static String NAME_METHOD = "name";
    private static String VALUE_METHOD = "value";

    private static ObjectMapper mapper = new ObjectMapper();

    static {
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        mapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
        mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
    }

    public static <T> String getAttributeValue(String attributeName, List<T> attributeList) {
        Optional<Method> nameMethod = getAttributeMethod(NAME_METHOD, attributeList);
        Optional<Method> valueMethod = getAttributeMethod(VALUE_METHOD, attributeList);
        if (CollectionUtils.isNotEmpty(attributeList) && nameMethod.isPresent() && valueMethod.isPresent()) {
            for (T a : attributeList) {
                String name;
                try {
                    name = ((String) nameMethod.get().invoke(a, null));
                    boolean matched = name.equalsIgnoreCase(attributeName);
                    if (matched) {
                        Object value = valueMethod.get().invoke(a, null);
                        return value + "";
                    }
                } catch (Exception e) {
                    log.error("ERR:Retrieving attribute value for attr {}.", attributeName);
                }
            }
        }
        return null;
    }

    public static <T> Object getAttributeValue(T attribute) {
        Optional<Method> valueMethod = getAttributeMethodFromAttribute(VALUE_METHOD, attribute);
        try {
            return valueMethod.get().invoke(attribute, null);
        } catch (Exception e1) {
            throw new RubixException(ERROR_CODE_400, e1.getCause().toString());
        }
    }

    public static <T, R> R getAttributeValue(T attribute, Class<R> type) {
        if(Objects.isNull(attribute))
            return null;
        Optional<Method> valueMethod = getAttributeMethodFromAttribute(VALUE_METHOD, attribute);
        try {

            Object val = valueMethod.get().invoke(attribute, null);
            return mapper.convertValue(val,type);
        } catch (Exception e1) {
            log.error("Exception occurred when getting attribute value with exception {}", e1.getCause());
            return null;
        }
    }

    public static <T> String getAttributeName(T attribute) {
        Optional<Method> nameMethod = getAttributeMethodFromAttribute(NAME_METHOD, attribute);
        try {
            return (String) nameMethod.get().invoke(attribute, null);
        } catch (Exception e1) {
            return null;
        }
    }

    public static <T> Optional<T> getAttribute(String attributeName, List<T> attributeList) {
        Optional<Method> nameMethod = getAttributeMethod(NAME_METHOD, attributeList);
        if (CollectionUtils.isNotEmpty(attributeList) && nameMethod.isPresent()) {
            return attributeList.stream()
                .filter(e -> {
                    try {
                        return ((String) nameMethod.get().invoke(e, null)).equalsIgnoreCase(attributeName);
                    } catch (Exception ex) {
                        throw new RubixException(ERROR_CODE_400, ex.getCause().toString());
                    }
                })
                .findFirst();
        } else {
            return Optional.empty();
        }
    }

    public static <T> List<Object> getAttributeValueList(Optional<T> attribute) {
        List updateAttributeValuesList = new ArrayList<>();
        if (attribute.isPresent()) {

            Object value = getAttributeValue(attribute.get());

            if (value instanceof ArrayNode) {
                return mapper.convertValue(value,List.class);
            }
        }
        return updateAttributeValuesList;
    }

    /**
     * By default when using context.getEvent().getAttribute(attributeName, Class)
     * Fluent will fail if there are any unknown fields.
     * This methods will not fail but ignore when on unknown fields and it will ignore key cases while doing deserialization
     *
     * @param attributeName attribute name to read
     * @param context       context to read data from
     * @param targetClass   target class to map
     * @return an instance of target class wrapped in an Optional
     */
    public static <T> Optional<T> getEventObjectAttribute(String attributeName, Context context, Class<T> targetClass) {
        return getEventObjectAttribute(attributeName, context.getEvent(), targetClass);
    }

    /**
     * By default when using context.getEvent().getAttribute(attributeName, Class)
     * Fluent will fail if there are any unknown fields.
     * This methods will not fail but ignore when on unknown fields and it will ignore key cases while doing deserialization
     *
     * @param attributeName attribute name to read
     * @param event context to read data from
     * @param targetClass target class to map
     * @return an instance of target class wrapped in an Optional
     */
    public static <T> Optional<T> getEventObjectAttribute(String attributeName, Event event, Class<T> targetClass) {
        if (StringUtils.isBlank(attributeName)) return Optional.empty();

        Map<String, Object> allAttributes = event.getAttributes();
        if (allAttributes == null || !allAttributes.containsKey(attributeName)) return Optional.empty();
        return convertValue(allAttributes.get(attributeName), targetClass);
    }

    public static <T> List<T> getEventListAttribute(String attributeName, Event event, Class<T> listItemClass) {
        if (StringUtils.isBlank(attributeName)) return new ArrayList<>();

        Map<String, Object> allAttributes = event.getAttributes();
        if (allAttributes == null || !allAttributes.containsKey(attributeName)) return new ArrayList<>();
        Optional<List> listOptional = convertValue(allAttributes.get(attributeName), List.class);
        if (!listOptional.isPresent()) return new ArrayList<>();
        return convertToList(listOptional.get(), listItemClass);
    }

    public static <T> List<T> convertToList(List<Object> list, Class<T> targetClass) {
        List<T> convertedList = new ArrayList<>();
        for (Object object : list) {
            Optional<T> listItem = convertValue(object, targetClass);
            listItem.ifPresent(convertedList::add);
        }
        return convertedList;
    }

    public static <T> Optional<T> convertValue(Object object, Class<T> targetClass) {
        ObjectMapper objectMapper = new ObjectMapper()
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
            .configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);
        T value = objectMapper.convertValue(object, targetClass);
        if (value == null) return Optional.empty();

        return Optional.of(value);
    }

    private static <T> Optional<Method> getAttributeMethod(String methodName, List<T> attributeList) {
        if (CollectionUtils.isNotEmpty(attributeList)) {
            return getAttributeMethodFromAttribute(methodName, attributeList.get(0));
        }
        return Optional.empty();
    }

    /**
     * To get  method with the given methodName
     *
     * @param <T>
     * @param methodName
     * @param attribute
     * @return
     */
    private static <T> Optional<Method> getAttributeMethodFromAttribute(String methodName, T attribute) {
        try {
            return Optional.ofNullable(attribute.getClass().getMethod(methodName, null));
        } catch (NoSuchMethodException e) {
            throw new RubixException(ERROR_CODE_400, e.getCause().toString());
        }
    }

    public static List<AttributeInput> of(Map<String, Object> attributes) {
        List<AttributeInput> attributeList = null;
        if (attributes != null) {
            attributeList = new ArrayList<>();
            for (Map.Entry<String, Object> attribute : attributes.entrySet()) {
                Object value = attribute.getValue();
                if (value == null) {
                    continue;
                }

                String type = "OBJECT";
                if (value instanceof String) {
                    if (((String) value).length() > com.fluentretail.api.model.attribute.Attribute.MAX_STRING_LENGTH) {
                        type = "TEXT";
                    } else {
                        type = "STRING";
                    }
                } else if (value instanceof Integer) {
                    type = "INTEGER";
                } else if (value instanceof Boolean) {
                    type = "BOOLEAN";
                } else if (value instanceof Address) {
                    type = "ADDRESS";
                }
                attributeList.add(AttributeInput.builder().name(attribute.getKey()).value(attribute.getValue()).type(type).build());
            }
        }

        return attributeList;
    }

    public static List<AttributeInput> convertAttributes(List<Attribute> attributes) {
        if(attributes == null) return null;
        return attributes.stream()
                .map(attribute -> AttributeInput.builder()
                        .name(attribute.getName())
                        .type(attribute.getType())
                        .value(attribute.getValue())
                        .build()
                )
                .collect(Collectors.toList());
    }

}
