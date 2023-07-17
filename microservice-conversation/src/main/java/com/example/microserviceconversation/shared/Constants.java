package com.example.microserviceconversation.shared;

public class Constants {
    // Category
    public static final int CATEGORY_BEAN = 1;
    public static final int CATEGORY_BOTTLE_MUG = 2;
    public static final int CATEGORY_DRIPPER = 3;
    public static final int CATEGORY_MAKER = 4;
    public static final int CATEGORY_K_CUP = 5;
    public static final int CATEGORY_DRINK = 6;
    public static final int CATEGORY_GRINDER = 7;
    public static final int CATEGORY_KETTLE = 8;
    public static final int CATEGORY_OTHERS = 9;

    // Refund Status
    public static final String REFUND_STATUS_NONE = "none";
    public static final String REFUND_STATUS_PENDING = "pending";
    public static final String REFUND_STATUS_REFUNDING = "refunding";
    public static final String REFUND_STATUS_REJECTED = "rejected";

    // Refund Report Status
    public static final String REFUND_REPORT_STATUS_REVIEWING = "reviewing";
    public static final String REFUND_REPORT_STATUS_RESOLVED = "resolved";

    // Order Status
    public static final String ORDER_STATUS_CART = "cart";
    public static final String ORDER_STATUS_SUCCEED = "succeed";
    public static final String ORDER_STATUS_FAILED = "failed";

    // User Role
    public static final int ROLE_CUSTOMER = 1;
    public static final int ROLE_ADMIN = 2;

    // User Activation
    public static final int USER_ACTIVE = 1;
    public static final int USER_INACTIVE = -1;

    // Product Discounted
    public static final int PRODUCT_HAS_DISCOUNT = 1;
    public static final int PRODUCT_NOT_DISCOUNT = -1;


    // Product Is Expired
    public static final int PRODUCT_IS_EXPIRED = 1;
    public static final int PRODUCT_NOT_EXPIRED = 0;

    // Address Is Expired
    public static final int ADDRESS_IS_EXPIRED = 1;
    public static final int ADDRESS_NOT_EXPIRED = 0;

    // Subscription Status
    public static final String SUBSCRIPTION_STATUS_ACTIVE = "active";
    public static final String SUBSCRIPTION_STATUS_INACTIVE = "inactive";

    // Conversation Status
    public static final String CONVERSATION_STATUS_ACTIVE = "active";
    public static final String CONVERSATION_STATUS_CLOSED = "closed";

    // Feedback visibility
    public static final String FEEDBACK_VISIBILITY_VISIBLE = "visible";
    public static final String FEEDBACK_VISIBILITY_HIDDEN = "hidden";
}
