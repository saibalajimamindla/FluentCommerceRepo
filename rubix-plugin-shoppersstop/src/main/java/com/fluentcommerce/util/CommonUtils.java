package com.fluentcommerce.util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fluentcommerce.common.ContextWrapper;
import com.fluentcommerce.model.common.LogCollection;
import com.fluentretail.api.model.attribute.Attribute;

import java.text.SimpleDateFormat;
import java.util.*;

public class CommonUtils {

    private CommonUtils() {}

    public static void newLog(ContextWrapper context) {
        LogCollection logs = context.getLogCollection();
        if(logs.isEmpty()) return;

        String ruleName = context.getRuleName();

        Objects.requireNonNull(context);
        Guard.requireNotNullString(ruleName);
        Objects.requireNonNull(logs);

        String serverDate = getServerTimeAsText();

        Attribute dateAttribute = Attribute.builder()
            .name("Date")
            .attributeType(Attribute.Type.STRING)
            .value(serverDate)
            .build();

        Attribute logCollectionAttribute = Attribute.builder()
            .name("LogCollection")
            .attributeType(Attribute.Type.OBJECT)
            .value(logs)
            .build();

        List<Attribute> attributes = new ArrayList<Attribute>() {{
            add(dateAttribute);
            add(logCollectionAttribute);
        }};

        if (context.getEvent() != null) {
            Attribute eventAttribute = Attribute.builder()
                .name("EventAttribute")
                .attributeType(Attribute.Type.OBJECT)
                .value(context.getEvent().getAttributes())
                .build();
            attributes.add(eventAttribute);
        }

        if (Thread.currentThread() != null) {
            Attribute threadNameAttribute = Attribute.builder()
                .name("ThreadName")
                .attributeType(Attribute.Type.STRING)
                .value(Thread.currentThread().getName())
                .build();
            attributes.add(threadNameAttribute);
        }

        if (CommonUtils.class.getClassLoader() != null) {
            Attribute classLoaderNameAttribute = Attribute.builder()
                .name("ClassLoader")
                .attributeType(Attribute.Type.STRING)
                .value(CommonUtils.class.getClassLoader().toString())
                .build();
            attributes.add(classLoaderNameAttribute);
        }

        context.action().log(ruleName, serverDate, attributes);
    }

    public static String getServerTimeAsText(){
        Date serverDateNow = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/YYYY HH:mm z", Locale.getDefault());
        return dateFormat.format(serverDateNow);
    }

    public static <T> T convertMapToDto(Map<String, Object> map, Class<T> cls) {
        final ObjectMapper mapper = new ObjectMapper();
        mapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return mapper.convertValue(map, cls);
    }

    public static <T> T convertObjectToDto(Object obj, Class<T> cls) {
        final ObjectMapper mapper = new ObjectMapper();
        mapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return mapper.convertValue(obj, cls);
    }

    public static <T> T convertObjectToDto(Object obj, TypeReference typeReference) {
        final ObjectMapper mapper = new ObjectMapper();
        mapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return mapper.convertValue(obj, typeReference);
    }

    public static Map<String, Object> convertDtoToMap(Object obj) {
        final ObjectMapper mapper = new ObjectMapper();
        mapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return mapper.convertValue(obj, Map.class);
    }
}
