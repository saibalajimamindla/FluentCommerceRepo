package com.fluentcommerce.service;

import com.fluentcommerce.commonv2.graphql.mutation.payment.CreateFinancialTransactionMutation;
import com.fluentcommerce.commonv2.graphql.type.CreateFinancialTransactionInput;
import com.fluentcommerce.commonv2.graphql.type.OrderId;
import com.fluentcommerce.model.payment.PaymentTransaction;
import com.fluentcommerce.util.RuleUtils;
import com.fluentretail.api.model.attribute.Attribute;
import com.fluentretail.rubix.v2.context.Context;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import static com.fluentcommerce.util.Constants.EventField.EVENT_FIELD_TRANSACTION_CODE;
import static com.fluentcommerce.util.Constants.EventField.EVENT_FIELD_TRANSACTION_ID;

@Slf4j
public class PaymentService {

    private static final String CLASS_NAME = PaymentService.class.getSimpleName();

    private Context context;

    public PaymentService(Context context) {
        this.context =  context;
    }

    public void createFinancialTransaction(PaymentTransaction paymentTransaction) {
        final String logPrefix = RuleUtils.buildLogPrefix(CLASS_NAME, context.getEvent());

        final CreateFinancialTransactionInput.Builder inputBuilder = CreateFinancialTransactionInput.builder()
            .ref(paymentTransaction.getRef())
            .type(paymentTransaction.getType())
            .amount(paymentTransaction.getAmount())
            .currency(paymentTransaction.getCurrencyCode())
            .paymentMethod(paymentTransaction.getPaymentMethod())
            .order(OrderId.builder().id(context.getEvent().getEntityId()).build());

        log.info("{} - checking attributes {} ", logPrefix, paymentTransaction.getAttributes());
        if (paymentTransaction.getAttributes() != null
            && CollectionUtils.isNotEmpty(paymentTransaction.getAttributes())) {
            for(Attribute attribute : paymentTransaction.getAttributes()) {
                log.info("{} - checking attribute name:{} value:{} valueString:{}",
                    logPrefix, attribute.getName(), attribute.getValue(), attribute.getValue(String.class));
                if (StringUtils.equals(attribute.getName(), EVENT_FIELD_TRANSACTION_ID)) {
                    inputBuilder.externalTransactionId(attribute.getValue(String.class));
                }
                if (StringUtils.equals(attribute.getName(), EVENT_FIELD_TRANSACTION_CODE)) {
                    inputBuilder.externalTransactionCode(attribute.getValue(String.class));
                }
            }
        }
        if (paymentTransaction.getCardType() != null) {
            inputBuilder.cardType(paymentTransaction.getCardType());
        }
        if (paymentTransaction.getPaymentServiceProviderRef() != null) {
            inputBuilder.paymentProvider(paymentTransaction.getPaymentServiceProviderRef());
        }
        log.info(logPrefix + " - Creating financial transaction ref:{}", paymentTransaction.getRef());
        context.action().mutation(CreateFinancialTransactionMutation.builder().input(inputBuilder.build()).build());
    }
}
