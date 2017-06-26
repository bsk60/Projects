package com.roadtex.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.roadtex.dao.AddressDao;
import com.roadtex.dao.CustomerDao;
import com.roadtex.dao.EmployeeDao;
import com.roadtex.dao.PermissionDao;
import com.roadtex.dao.RoleDao;
import com.roadtex.model.Address;
import com.roadtex.model.Customer;
import com.roadtex.model.Employee;
import com.roadtex.model.Permissions;
import com.roadtex.model.Role;

public class RoadTexController extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final String LOGIN = "/index.jsp";
	private final String HOME = "/Home.jsp";
	private final String USERMAN = "/UserManagement.jsp";
	private final String ROLE = "/Role.jsp";
	private final String ROLEPERM = "/RolePermission.jsp";
	private final String ADDCUS = "/AddCustomer.jsp";
	private final String LOGOUT = "/Logout.jsp";
	private final String UPDATEUSER = "/UpdateUser.jsp";
	private final String UPDATEROLE = "/UpdateRole.jsp";
	private final String UPDATECUS = "/UpdateCustomer.jsp";
	RoleDao roleDao;
	EmployeeDao empDao;
	CustomerDao cusDao;
	PermissionDao permDao;
	AddressDao addressDao;
	Employee emp;
	Role role;

	public RoadTexController() {
		super();
		roleDao = new RoleDao();
		empDao = new EmployeeDao();
		cusDao = new CustomerDao();
		permDao = new PermissionDao();
		addressDao = new AddressDao();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String forward = "";
		String action = request.getParameter("action");

		if (action.equalsIgnoreCase("login")) {
			forward = LOGIN;
		} else if (action.equalsIgnoreCase("home")) {
			forward = HOME;
			// Employee empl = (Employee) request.getAttribute("empObject");
			HttpSession session = request.getSession();
			// List<Employee> list = empDao.getListOfUsers();
			// request.setAttribute("empList", list);
			request.setAttribute("empObject", emp);
			List<Customer> list = cusDao.getListOfClients();
			request.setAttribute("clientList", list);

		} else if (action.equalsIgnoreCase("userman")) {

			request.getSession().setAttribute("user", request.getSession().getAttribute("user"));

			forward = USERMAN;
			HttpSession session = request.getSession();
			List<Employee> list = empDao.getListOfUsers();
			request.setAttribute("empList", list);
			List<Role> list2 = roleDao.getListOfRoles();
			request.setAttribute("roleList", list2);

		} else if (action.equalsIgnoreCase("role")) {
			forward = ROLE;
			HttpSession session = request.getSession();
			List<Role> list = roleDao.getListOfRoles();
			request.setAttribute("roleList", list);
			// System.out.println(session.getAttribute("user"));

		} else if (action.equalsIgnoreCase("roleperm")) {
			forward = ROLEPERM;
			HttpSession session = request.getSession();
			List<Role> list = roleDao.getListOfRoles();
			request.setAttribute("roleList", list);
			List<Permissions> list2 = permDao.getListOfPermissions();
			request.setAttribute("permList", list2);

		} else if (action.equalsIgnoreCase("addcus")) {
			HttpSession session = request.getSession();
			List<Customer> list = cusDao.getListOfClients();
			request.setAttribute("clientList", list);
			forward = ADDCUS;

		} else if (action.equalsIgnoreCase("updateuser")) {
			forward = UPDATEUSER;
			String email = request.getParameter("email");
			request.setAttribute("empObject", empDao.getUserByEmail(email));
			List<Role> list2 = roleDao.getListOfRoles();
			request.setAttribute("roleList", list2);

		} else if (action.equalsIgnoreCase("deleteuser")) {
			String email = request.getParameter("email");
			Employee emp = empDao.getUserByEmail(email);
			empDao.deleteUser(emp);
			// request.setAttribute("empObject",emp);
			List<Employee> list = empDao.getListOfUsers();
			request.setAttribute("empList", list);
			List<Role> list2 = roleDao.getListOfRoles();
			request.setAttribute("roleList", list2);
			forward = USERMAN;
		} else if (action.equalsIgnoreCase("updaterole")) {
			String name = request.getParameter("name");
			Role role = roleDao.getRoleByName(name);
			request.setAttribute("roleObject", role);
			forward = UPDATEROLE;
		} else if (action.equalsIgnoreCase("updatecus")) {
			int id = Integer.parseInt(request.getParameter("id"));
			Customer cus = cusDao.getCustomerById(id);
			request.setAttribute("cusObject", cus);
			forward = UPDATECUS;

		} else if (action.equalsIgnoreCase("deletecus")) {
			// String email = request.getParameter("email");
			// Employee emp = empDao.getUserByEmail(email);
			// empDao.deleteUser(emp);
			// request.setAttribute("empObject",emp);
			// List<Employee> list = empDao.getListOfUsers();
			// request.setAttribute("empList", list);
			// List<Role> list2 = roleDao.getListOfRoles();
			// request.setAttribute("roleList", list2);
			// forward = USERMAN;
			int id = Integer.parseInt(request.getParameter("id"));
			Customer cus = cusDao.getCustomerById(id);
			Address address = addressDao.getAddressById(id);
			cusDao.delete(address, cus);

			List<Customer> list = cusDao.getListOfClients();
			request.setAttribute("clientList", list);
			forward = ADDCUS;

		} else if (action.equalsIgnoreCase("deleterole")) {
			String name = request.getParameter("name");
			Role role = roleDao.getRoleByName(name);
			Boolean result = roleDao.deleteRole(role);
			// request.setAttribute("empObject",emp);
			List<Employee> list = empDao.getListOfUsers();
			request.setAttribute("empList", list);
			List<Role> list2 = roleDao.getListOfRoles();
			request.setAttribute("roleList", list2);
			if (result) {
				forward = ROLE;
				request.setAttribute("status", true);
			} else {

				forward = USERMAN;
				request.setAttribute("status", false);
			}

		} else if (action.equalsIgnoreCase("logout")) {

			forward = LOGOUT;
		}

		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Session session = AppUtil.openSession();
		String forward = "";
		String action = request.getParameter("action");

		if (action.equalsIgnoreCase("login")) {
			String email = request.getParameter("email");
			String password = request.getParameter("pass");
			boolean result = empDao.authenticateEmployee(email, password);

			if (result) {
				request.setAttribute("empObject", empDao.getUserByEmail(email));
				Employee empl = (Employee) request.getAttribute("empObject");
				String user = empl.getFname();
				int role = empl.getRole().getRoleID();
				request.getSession().setAttribute("user", user);
				// System.out.println(" empl role id : " +
				// empl.getRole().getRoleID());

				request.getSession().setAttribute("role", role);
				forward = HOME;
				List<Customer> list = cusDao.getListOfClients();
				request.setAttribute("clientList", list);

			} else {
				forward = LOGIN;
			}

		} else if (action.equalsIgnoreCase("home")) {
			forward = HOME;
		} else if (action.equalsIgnoreCase("adduser")) {
			Employee emp;
			String fname = request.getParameter("fname");
			String lname = request.getParameter("lname");
			String email = request.getParameter("email");
			String pass = request.getParameter("pass");
			Role r = roleDao.getRoleByName(request.getParameter("roleName"));
			// System.out.println(request.getParameter("roleName"));
			emp = new Employee(fname, lname, email, pass, r);
			empDao.addUser(emp);

			List<Employee> list = empDao.getListOfUsers();
			request.setAttribute("empList", list);
			List<Role> list2 = roleDao.getListOfRoles();
			request.setAttribute("roleList", list2);

			forward = USERMAN;
		} else if (action.equalsIgnoreCase("role")) {
			forward = ROLE;
		} else if (action.equalsIgnoreCase("roleperm")) {
			forward = ROLEPERM;
		} else if (action.equalsIgnoreCase("addcus")) {
			Customer cus;
			String clientName = request.getParameter("clientName");
			String contactName = request.getParameter("contactName");
			String phone = request.getParameter("phone");
			String email = request.getParameter("email");
			String offer = request.getParameter("offer");
			String isCustomer = request.getParameter("isCustomer");
			// boolean isCustomer = isChecked(result);
			String street = request.getParameter("street");
			String city = request.getParameter("city");
			String state = request.getParameter("state");
			String zip = request.getParameter("zip");

			Address address = new Address(street, city, state, zip);
			cus = new Customer(clientName, contactName, phone, email, offer, isCustomer, address);
			cusDao.addClient(address, cus);

			List<Customer> list = cusDao.getListOfClients();
			request.setAttribute("clientList", list);
			forward = ADDCUS;
		} else if (action.equalsIgnoreCase("addrole")) {

			String rolename = request.getParameter("rolename");
			String roleDesc = request.getParameter("roledesc");
			role = new Role(rolename, roleDesc);
			roleDao.addRole(role);

			List<Role> list = roleDao.getListOfRoles();
			request.setAttribute("roleList", list);
			forward = ROLE;

		} else if (action.equalsIgnoreCase("addperm")) {

			Permissions perm;
			Role r = roleDao.getRoleByName(request.getParameter("roleName"));

			boolean addCustomer;
			if (request.getParameter("addCustomer") != null) {
				addCustomer = true;
			} else {
				addCustomer = false;
			}
			boolean changePass;
			if (request.getParameter("changePass") != null) {
				changePass = true;
			} else {
				changePass = false;
			}
			boolean adminSettings;
			if (request.getParameter("adminSettings") != null) {
				adminSettings = true;
			} else {
				adminSettings = false;
			}
			boolean users;
			if (request.getParameter("users") != null) {
				users = true;
			} else {
				users = false;
			}
			boolean userSettings;
			if (request.getParameter("userSettings") != null) {
				userSettings = true;
			} else {
				userSettings = false;
			}
			boolean roles;
			if (request.getParameter("roles") != null) {
				roles = true;
			} else {
				roles = false;
			}
			boolean rolesPermission;
			if (request.getParameter("rolesPermission") != null) {
				rolesPermission = true;
			} else {
				rolesPermission = false;
			}

			perm = new Permissions(r, addCustomer, changePass, adminSettings, users, userSettings, roles,
					rolesPermission);

			permDao.setPermissions(perm);

			forward = ROLEPERM;
			List<Role> list = roleDao.getListOfRoles();
			request.setAttribute("roleList", list);
			List<Permissions> list2 = permDao.getListOfPermissions();
			request.setAttribute("permList", list2);

		} else if (action.equalsIgnoreCase("doupdateuser")) {
			forward = USERMAN;
			Employee emp;
			int empID = Integer.parseInt(request.getParameter("empID"));
			String fname = request.getParameter("fname");
			String lname = request.getParameter("lname");
			String email = request.getParameter("email");
			String pass = request.getParameter("pass");
			Role r = roleDao.getRoleByName(request.getParameter("roleName"));
			// System.out.println(request.getParameter("roleName"));
			emp = new Employee(empID, fname, lname, email, pass, r);
			empDao.updateUser(emp);
			List<Employee> list = empDao.getListOfUsers();
			request.setAttribute("empList", list);
			List<Role> list2 = roleDao.getListOfRoles();
			request.setAttribute("roleList", list2);
		} else if (action.equalsIgnoreCase("doupdaterole")) {
			int roleID = Integer.parseInt(request.getParameter("roleID"));
			String name = request.getParameter("roleName");
			String roleDesc = request.getParameter("roleDesc");

			Role role = new Role(roleID, name, roleDesc);
			roleDao.updateRole(role);
			List<Role> list = roleDao.getListOfRoles();
			request.setAttribute("roleList", list);
			forward = ROLE;
		} else if (action.equalsIgnoreCase("doupdatecus")) {
			Customer cus;
			int id = Integer.parseInt(request.getParameter("id"));
			String clientName = request.getParameter("clientName");
			String contactName = request.getParameter("contactPerson");
			String phone = request.getParameter("phone");
			String email = request.getParameter("email");
			String offer = request.getParameter("offer");
			String isCustomer = request.getParameter("isCustomer");
			String street = request.getParameter("street");
			String city = request.getParameter("city");
			String state = request.getParameter("state");
			String zip = request.getParameter("zip");
			int addID = cusDao.getCustomerById(id).getAddress().getAddressID();
			Address address = new Address(addID, street, city, state, zip);
			cus = new Customer(id, clientName, contactName, phone, email, offer, isCustomer, address);
			cusDao.update(cus, address);

			List<Customer> list = cusDao.getListOfClients();
			request.setAttribute("clientList", list);
			forward = ADDCUS;
		} else if (action.equalsIgnoreCase("logout")) {

			forward = LOGOUT;
		}

		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);
	}

	public boolean isChecked(String str) {
		if (str != null) {
			return true;
		} else {
			return false;
		}
	}

}
