package com.aiotdelivery.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.aiotdelivery.bean.EmpBean;

public class EmpDAO {

	private static final String GET_ONE =
			"SELECT * FROM employee WHERE empno = ?";
	public static final String GET_ALL_EMPS =
			"SELECT * FROM employee";
	private static final String INSERT_ONE_EMP =
			"INSERT INTO employee VALUES (?, ?, ?, ?, ?, ?)";
	private static final String DELETE_EMP =
			"DELETE FROM employee WHERE empno = ?";
	private static final String UPDATE_EMP =
			"UPDATE employee SET ename = ?, hiredate = ?, salary = ?, deptno = ?, title = ? WHERE empno = ?";
	private static final String SEARCH_KEYWORDS =
			"SELECT * FROM employee WHERE ename LIKE ?";
	
	private Connection conn;

	public EmpDAO() {
		try {
			Context context = new InitialContext();
			DataSource ds = (DataSource) context.lookup("java:/comp/env/jdbc/servdb");
			conn = ds.getConnection();
		} catch (NamingException | SQLException e) {
			e.printStackTrace();
		}
	}

	public EmpBean getEmp(String empno) {
		EmpBean emp = null;
		try {			
			PreparedStatement stmt = conn.prepareStatement(GET_ONE);
			stmt.setString(1, empno);
			ResultSet rs = stmt.executeQuery();
			emp = new EmpBean();
			if (rs.next()) {
				emp.setEmpno(rs.getString("empno"));
				emp.setEname(rs.getString("ename"));
				emp.setHiredate(rs.getString("hiredate"));
				emp.setSalary(rs.getString("salary"));
				emp.setDeptno(rs.getString("deptno"));
				emp.setTitle(rs.getString("title"));
			}
			stmt.close();
		}  catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return emp;
	}

	public List<EmpBean> getEmpBeans() {
		List<EmpBean> emps = null;
		try {
			PreparedStatement stmt = conn.prepareStatement(GET_ALL_EMPS);
			ResultSet rs = stmt.executeQuery();
			emps = new ArrayList<>();
			EmpBean emp;
			while (rs.next()) {
				emp = new EmpBean();
				emp.setEmpno(rs.getString("empno"));
				emp.setEname(rs.getString("ename"));
				emp.setHiredate(rs.getString("hiredate"));
				emp.setSalary(rs.getString("salary"));
				emp.setDeptno(rs.getString("deptno"));
				emp.setTitle(rs.getString("title"));
				emps.add(emp);
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return emps;
	}

	public void insertEmp(EmpBean emp) {
		try {
			// INSERT
			PreparedStatement pstmt = conn.prepareStatement(INSERT_ONE_EMP);
			pstmt.setString(1, emp.getEmpno());
			pstmt.setString(2, emp.getEname());
			pstmt.setString(3, emp.getHiredate());
			pstmt.setString(4, emp.getSalary());
			pstmt.setString(5, emp.getDeptno());
			pstmt.setString(6, emp.getTitle());
			pstmt.execute();
			System.out.println("INSERT success!");
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public void deleteEmp(String empno) {
		try {
			// DELETE
			PreparedStatement pstmt = conn.prepareStatement(DELETE_EMP);
			pstmt.setString(1, empno);
			pstmt.execute();
			System.out.println("DELETE success!");
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public void updateEmp(EmpBean emp) {
		try {
			// UPDATE
			PreparedStatement pstmt = conn.prepareStatement(UPDATE_EMP);
			pstmt.setString(1, emp.getEname());
			pstmt.setString(2, emp.getHiredate());
			pstmt.setString(3, emp.getSalary());
			pstmt.setString(4, emp.getDeptno());
			pstmt.setString(5, emp.getTitle());
			pstmt.setString(6, emp.getEmpno());
			pstmt.execute();
			System.out.println("UPDATE success!");
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public List<EmpBean> searchName(String ename) {
		List<EmpBean> emps = null;
		try {
			// LIKE
			String keyword = "%"+ename+"%";
			PreparedStatement pstmt = conn.prepareStatement(SEARCH_KEYWORDS);
			pstmt.setString(1, keyword);
			ResultSet rs = pstmt.executeQuery();
			emps = new ArrayList<>();
			EmpBean emp;
			while (rs.next()) {
				emp = new EmpBean();
				emp.setEmpno(rs.getString("empno"));
				emp.setEname(rs.getString("ename"));
				emp.setHiredate(rs.getString("hiredate"));
				emp.setSalary(rs.getString("salary"));
				emp.setDeptno(rs.getString("deptno"));
				emp.setTitle(rs.getString("title"));
				emps.add(emp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return emps;
	}

}
