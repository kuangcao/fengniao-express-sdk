package com.jiabangou.fnexpress.api.impl;

import com.jiabangou.fnexpress.api.ServiceTest;
import com.jiabangou.fnexpresssdk.api.OrderService;
import com.jiabangou.fnexpresssdk.exception.FnExpressErrorException;
import com.jiabangou.fnexpresssdk.model.Item;
import com.jiabangou.fnexpresssdk.model.Order;
import com.jiabangou.fnexpresssdk.model.ReceiverInfo;
import com.jiabangou.fnexpresssdk.model.TransportInfo;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wanglei on 16-12-14.
 */
public class OrderServiceImplTest extends ServiceTest {

    @Test
    public void createOrder() throws FnExpressErrorException {
        OrderService orderService = expressClient.getOrderService();
        orderService.createOrder(buildOrder());
    }

    private Order buildOrder() {
        Order order = new Order();
        order.setPartner_remark("测试商户1");
        order.setPartner_order_code("test_order_1");
        order.setNotify_url("http://mp.test.xiaoyage.com");
        order.setOrder_type(1);
        order.setTransport_info(buildTransportInfo());
        order.setOrder_add_time(System.currentTimeMillis());
        order.setOrder_total_amount(100.0);
        order.setOrder_actual_amount(100.0);
        order.setOrder_weight(5.0);
        order.setOrder_remark("不要葱花和香菜");
        order.setIs_invoiced(0);
        order.setInvoice("北京延庆大帝国有限公司");
        order.setOrder_payment_status(1);
        order.setOrder_payment_method(1);
        order.setIs_agent_payment(1);
        order.setRequire_payment_pay(100.0);
        order.setGoods_count(5);
        order.setRequire_receive_time(System.currentTimeMillis());
        order.setReceiver_info(buildReceiverInfo());
        order.setItems_json(buildItems());
        order.setSerial_number("1");
        return order;
    }

    private TransportInfo buildTransportInfo() {
        TransportInfo transportInfo = new TransportInfo();
        transportInfo.setTransport_name("测试门店1");
        transportInfo.setTransport_address("和平门地铁站"); //116.391408,39.906124
        transportInfo.setTransport_longitude(116.391408);
        transportInfo.setTransport_latitude(39.906124);
        transportInfo.setPosition_source(3);
        transportInfo.setTransport_tel("13651187030");
        transportInfo.setTransport_remark("测试");
        return transportInfo;
    }

    private ReceiverInfo buildReceiverInfo() {
        ReceiverInfo receiverInfo = new ReceiverInfo();
        receiverInfo.setReceiver_name("测试门店1");
        receiverInfo.setReceiver_primary_phone("13651187030");
        receiverInfo.setReceiver_address("和平门地铁站"); //116.391408,39.906124
        receiverInfo.setReceiver_longitude(116.391408);
        receiverInfo.setReceiver_latitude(39.906124);
        receiverInfo.setPosition_source(3);
        receiverInfo.setReceiver_second_phone("13651187030");
        return receiverInfo;
    }

    private List<Item> buildItems() {
        List<Item> items = new ArrayList<>();
        Item item = new Item();
        item.setItem_id("test_item_1");
        item.setItem_name("测试商品1");
        item.setItem_quantity(10);
        item.setItem_price(100.0);
        item.setItem_actual_price(100.0);
        item.setItem_size(5);
        item.setItem_remark("测试");
        item.setIs_need_package(1);
        item.setIs_agent_purchase(1);
        item.setAgent_purchase_price(10.0);
        items.add(item);
        return items;
    }
}
