package api;

import exception.FnExpressErrorException;
import model.NextDayOrder;
import model.Order;
import model.OrderDetail;

/**
 * Created by wanglei   on 16-9-29.
 */
public interface OrderService {

    void createOrder(Order order) throws FnExpressErrorException;

    void createNextDayOrder(NextDayOrder order) throws FnExpressErrorException;

    OrderDetail getOrderDetail(String tpOrderId) throws FnExpressErrorException;

    void syncCancelOrder(String tpOrderId, Integer reasonCode, String description) throws FnExpressErrorException;

}
