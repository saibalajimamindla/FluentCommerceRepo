package com.fluentcommerce.util;

import com.fluentcommerce.commonv2.graphql.query.fulfilmentOption.GetFulfilmentOptionByIdQuery;
import com.fluentcommerce.model.attribute.Attribute;
import com.fluentcommerce.model.fulfilmentOption.FulfilmentOption;
import com.fluentcommerce.model.fulfilmentOption.Product;
import com.fluentretail.rubix.v2.context.Context;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.apache.commons.collections4.CollectionUtils.isEmpty;

@Slf4j
public class FulfilmentOptionUtils {

    private static final String CLASS_NAME = FulfilmentOptionUtils.class.getSimpleName();

    public static FulfilmentOption mapFulfilmentOptionToDto(Context context,
        GetFulfilmentOptionByIdQuery.FulfilmentOptionById fulfilmentOptionById) {
        FulfilmentOption.Builder fulfilmentOption = FulfilmentOption.builder()
            .id(fulfilmentOptionById.id())
            .ref(fulfilmentOptionById.ref())
            .type(fulfilmentOptionById.type())
            .createdOn((Date)fulfilmentOptionById.createdOn())
            .updatedOn((Date)fulfilmentOptionById.updatedOn())
            .retailerId(fulfilmentOptionById.retailerId())
            .orderType(fulfilmentOptionById.orderType())
            .pickupLocationRef(fulfilmentOptionById.locationRef());
        mapFulfilmentOptionAddressToDto(context, fulfilmentOptionById, fulfilmentOption);
        mapFulfilmentOptionAttributesToDto(context, fulfilmentOptionById, fulfilmentOption);
        return fulfilmentOption.build();
    }

    public static List<Product> mapFulfilmentOptionProductsToDto(Context context,
        GetFulfilmentOptionByIdQuery.FulfilmentOptionById fulfilmentOptionById) {
        final String logPrefix = RuleUtils.buildLogPrefix(CLASS_NAME, context.getEvent());

        if (fulfilmentOptionById.products() == null
            || isEmpty(fulfilmentOptionById.products())
        ) {
            log.info("{} - products is null or empty for fulfilment option id:{}", logPrefix, fulfilmentOptionById.id());
            return null;
        }
        List<Product> products = new ArrayList<>();
        for (GetFulfilmentOptionByIdQuery.Product fulfilmentOptionProduct : fulfilmentOptionById.products()) {
            Product product = Product.builder()
                .catalogueRef(fulfilmentOptionProduct.catalogueRef())
                .productRef(fulfilmentOptionProduct.productRef())
                .requestedQuantity(fulfilmentOptionProduct.requestedQuantity())
                .build();
            products.add(product);
        }
        return products;
    }

    private static void mapFulfilmentOptionAddressToDto(Context context,
        GetFulfilmentOptionByIdQuery.FulfilmentOptionById fulfilmentOptionById,
        FulfilmentOption.Builder fulfilmentOption) {
        final String logPrefix = RuleUtils.buildLogPrefix(CLASS_NAME, context.getEvent());

        if (fulfilmentOptionById.address() == null) {
            log.info("{} - address is null for fulfilment option id:{}", logPrefix, fulfilmentOptionById.id());
            return;
        }
        GetFulfilmentOptionByIdQuery.Address address = fulfilmentOptionById.address();
        fulfilmentOption.addressName(address.name());
        fulfilmentOption.companyName(address.companyName());
        fulfilmentOption.addressLine1(address.addressLine1());
        fulfilmentOption.addressLine2(address.addressLine2());
        fulfilmentOption.city(address.city());
        fulfilmentOption.state(address.state());
        fulfilmentOption.postcode(address.postcode());
        fulfilmentOption.country(address.country());
        fulfilmentOption.longitude(address.longitude());
        fulfilmentOption.latitude(address.latitude());
    }

    private static void mapFulfilmentOptionAttributesToDto(Context context,
        GetFulfilmentOptionByIdQuery.FulfilmentOptionById fulfilmentOptionById,
        FulfilmentOption.Builder fulfilmentOption) {
        final String logPrefix = RuleUtils.buildLogPrefix(CLASS_NAME, context.getEvent());

        if (fulfilmentOptionById.attributes() == null) {
            return;
        }
        List<Attribute> attributeList = new ArrayList<>();
        for(GetFulfilmentOptionByIdQuery.Attribute attribute : fulfilmentOptionById.attributes()) {
            attributeList.add(Attribute.from(attribute));
        }
        fulfilmentOption.attributes(attributeList);
    }
}
