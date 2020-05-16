package com.cybertek.tests.day21_db_testing;

import com.cybertek.utilities.DBUtils;
import org.testng.annotations.Test;

public class DbUtilityDemo {

    @Test
    public void test1() throws Exception {
        // "jdbc:database_type:@ip_address:port:sid/db-name"
        String url = "jdbc:mysql://107.23.27.171:3306/bitnami_orocrm";
        String username = "qa_user";
        String password = "qa_user";

        DBUtils.createConnection(url, username, password);

        String sql = "select  orocrm_contact.first_name, orocrm_contact.last_name, orocrm_contact_email.email \n" +
                "from orocrm_contact\n" +
                "join orocrm_contact_email\n" +
                "on orocrm_contact.id =orocrm_contact_email.owner_id\n" ;

        System.out.println(DBUtils.getRowMap(sql));

    }
}
