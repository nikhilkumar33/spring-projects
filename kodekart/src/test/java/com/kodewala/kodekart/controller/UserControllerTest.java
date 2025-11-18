package com.kodewala.kodekart.controller;

import static org.mockito.Mockito.*;
import static org.junit.Assert.assertEquals;

import java.sql.Connection;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.MockedConstruction;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import com.kodewala.kodekart.services.AdminImplementation;
import com.kodewala.kodekart.services.KodeKartImplementation;
import com.kodewala.kodekart.services.UserImplementation;

public class UserControllerTest {

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    Connection con = mock(Connection.class);

    // ======================================================
    // TEST 1: Exit (Case 3)
    // ======================================================
    @Test
    public void testCloseKodeKart() {

        try (
            MockedConstruction<KodeKartImplementation> mk =
                mockConstruction(KodeKartImplementation.class,
                    (mock, ctx) -> when(mock.basePage()).thenReturn(3));

            MockedConstruction<AdminImplementation> ma =
                mockConstruction(AdminImplementation.class);

            MockedConstruction<UserImplementation> mu =
                mockConstruction(UserImplementation.class)
        ) {

            UserController controller = new UserController();
            int result = controller.controlUser(con);

            assertEquals(0, result);
        }
    }

    // ======================================================
    // TEST 2: Register → Success → Exit
    // ======================================================
    @Test
    public void testRegisterSuccess() {

        try (
            MockedConstruction<KodeKartImplementation> mk =
                mockConstruction(KodeKartImplementation.class,
                    (mock, ctx) -> {
                        when(mock.basePage()).thenReturn(1, 3);
                        when(mock.register(con)).thenReturn(true);
                    });

            MockedConstruction<AdminImplementation> ma =
                mockConstruction(AdminImplementation.class);

            MockedConstruction<UserImplementation> mu =
                mockConstruction(UserImplementation.class)
        ) {

            UserController controller = new UserController();
            int result = controller.controlUser(con);

            assertEquals(0, result);
        }
    }

    // ======================================================
    // TEST 3: User login → userHome() logout
    // ======================================================
    @Test
    public void testUserLoginAndLogout() {

        try (
            MockedConstruction<KodeKartImplementation> mk =
                mockConstruction(KodeKartImplementation.class,
                    (mock, ctx) -> {
                        when(mock.basePage()).thenReturn(2, 3);
                        when(mock.isAdmin(con)).thenReturn(false);
                        when(mock.login(con)).thenReturn(10);
                    });

            MockedConstruction<UserImplementation> mu =
                mockConstruction(UserImplementation.class,
                    (mock, ctx) -> when(mock.userHome()).thenReturn(6));

            MockedConstruction<AdminImplementation> ma =
                mockConstruction(AdminImplementation.class)
        ) {

            UserController controller = new UserController();
            int result = controller.controlUser(con);

            assertEquals(0, result);
        }
    }

    // ======================================================
    // TEST 4: Admin login → adminHome() logout
    // ======================================================
    @Test
    public void testAdminLoginAndLogout() {

        try (
            MockedConstruction<KodeKartImplementation> mk =
                mockConstruction(KodeKartImplementation.class,
                    (mock, ctx) -> {
                        when(mock.basePage()).thenReturn(2, 3);
                        when(mock.isAdmin(con)).thenReturn(true);
                        when(mock.login(con)).thenReturn(1);
                    });

            MockedConstruction<AdminImplementation> ma =
                mockConstruction(AdminImplementation.class,
                    (mock, ctx) -> when(mock.adminHome()).thenReturn(6));

            MockedConstruction<UserImplementation> mu =
                mockConstruction(UserImplementation.class)
        ) {

            UserController controller = new UserController();
            int result = controller.controlUser(con);

            assertEquals(0, result);
        }
    }
}
