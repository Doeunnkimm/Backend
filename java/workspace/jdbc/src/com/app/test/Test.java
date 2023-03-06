package com.app.test;

import com.app.dao.UserDAO;
import com.app.domain.UserVO;

public class Test {
   public static void main(String[] args) {
      UserDAO userDAO = new UserDAO();
      
      System.out.println(userDAO.checkId("hds31234"));
      
//      UserVO userVO = new UserVO();
//      
//      userVO.setUserIdentification("hds1234");
//      userVO.setUserPassword("1234");
//      userVO.setUserName("ÇÑµ¿¼®");
//      userVO.setUserPhone("01012341234");
//      userVO.setUserEmail("tedhan1204@gmail.com");
//      
//      userDAO.insert(userVO);
      
   }
}










