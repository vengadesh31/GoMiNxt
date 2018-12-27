package com.niit.EComBack.dao;
import java.util.List;
import javax.persistence.Entity;
import com.niit.EComBack.model.MyOrder;
@Entity
public interface OrderDao 
{
	public boolean Placeorder(MyOrder order);
	 List<MyOrder>ViewOrder(int cardid);
	 MyOrder Showorder(String orderid);
}

