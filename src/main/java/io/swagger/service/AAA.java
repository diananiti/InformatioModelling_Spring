package io.swagger.service;

import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import io.swagger.model.User;
import io.swagger.model.Users;
import io.swagger.model.Users;

public class AAA {

    //Initialize the employees list
    static Users sts = new Users();
    static
    {   sts.setUsers(new ArrayList<User>());
        //sts.setStudents();
        //Create two employees
        User st1 = new User();
        st1.setUsername("Jan");
        st1.setEmail("Kowalski");
        st1.setPassword("pass");
        st1.setId(1L);
        User st2 = new User();
        st2.setUsername("Adam");
        st2.setEmail("Nowak");
        st2.setPassword("pass2");
        st2.setId(2L);
        //Add the employees in list
        sts.getUsers().add(st1);
        sts.getUsers().add(st2);
    }
    private static void marshalingExample() throws JAXBException
    {
        JAXBContext jaxbContext = JAXBContext.newInstance(Users.class);
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        //Marshal the employees list in console
        jaxbMarshaller.marshal(sts, System.out);

    }

    public static void main(String[] args) throws JAXBException {
        marshalingExample();
    }

}
