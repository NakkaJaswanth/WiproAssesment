package SpringMain;

import Wiprospringframework.Account;
import Wiprospringframework.Item;
import Wiprospringframework.LoginDetails;
import Wiprospringframework.Purchase;
import Wiprospringframework.SampleBean;
import Wiprospringframework.ShoppingService;
import Wiprospringframework.Student;
import Wiprospringframework.Student_Course;



import org.springframework.context.ApplicationContext;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class samplemain {
    public static void main(String[] args) {

      
        ApplicationContext xmlContext = new ClassPathXmlApplicationContext("WiproIOCContainer.xml");

        SampleBean b1 = (SampleBean) xmlContext.getBean("mybean1");
        System.out.println("Welcome Spring By:: " + b1.getUsername());

        Student student = (Student) xmlContext.getBean("mybean2");
        System.out.println("Student Data:: " + student.getSid() + " " + student.getSname());

        Student_Course sc = (Student_Course) xmlContext.getBean("mybean3");
        System.out.println("Student Course:: " + sc.getSid() + " " + sc.getSname() + " " + sc.getCourseid() + " " + sc.getCoursename());

        Account account = (Account) xmlContext.getBean("account");
        account.printDetails();
        
        Item item = xmlContext.getBean(Item.class);
        item.displayDetails();
        
        LoginDetails login = (LoginDetails) xmlContext.getBean("login");
        login.display();
        
        Purchase purchase = (Purchase) xmlContext.getBean("purchase");
        purchase.display();
        
        ShoppingService shoppingService = (ShoppingService) xmlContext.getBean("shoppingService");
        shoppingService.addToCart("Laptop");
        shoppingService.makePayment(55000);
        shoppingService.placeOrder();
       
    }


    }

