package com.yjc.www.test;

import com.yjc.www.dao.ICustomerDao;
import com.yjc.www.dao.impl.CustomerDaoImpl;
import com.yjc.www.po.Customer;
import com.yjc.www.po.Order;
import org.junit.Test;

import java.util.List;

public class CustomerDaoTest {
        public  Customer customer =new Customer();

        //映入DAO层
        private ICustomerDao dao = new CustomerDaoImpl();

        @Test
        public void testSave() {
            Customer cm =new Customer(2,"messi",800,"18823233436","Barcelona","123834");
            dao.save(cm);
        }

        @Test
        public void testDelete(){
            customer.setId(1);
            dao.delete(customer);
        }

        @Test
        public void testUpdate(){
            Customer cm =new Customer(2,"messi",800,"18823233436","Barcelona","123834");
            dao.update(cm);
        }

        @Test
        public void testGet(){
            Customer cm = dao.getById(1);
            System.out.println(cm);
        }

        @Test
        public void testLogin(){
            Integer login = dao.login("customer","hhh");
            System.out.println(login);
        }

        @Test
        public void testList(){
            List<Customer> list= dao.getAll();
            for (Customer cm : list) {
                System.out.println(cm);
            }
        }

        @Test
        public void testCustomerOrder(){
            List<Order> list = dao.getCustomerOrder(1);
            for (Order order:list){
                System.out.println(order);
            }
        }
}
