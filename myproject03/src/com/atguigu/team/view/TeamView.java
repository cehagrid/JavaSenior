package com.atguigu.team.view;

import com.atguigu.team.domain.Employee;
import com.atguigu.team.domain.Programmer;
import com.atguigu.team.service.NameListService;
import com.atguigu.team.service.TeamException;
import com.atguigu.team.service.TeamService;

public class TeamView {
//			- listSvc: NameListService = new NameListService()
//			- teamSvc: TeamService = new TeamService()
	private NameListService listSvc = new NameListService();
	private TeamService teamSvc = new TeamService();

//			+ enterMainMenu(): void 
//			- listAllEmployees(): void 
//			- getTeam():void
//			- addMember(): void 
//			- deleteMember(): void 
//			+ main(args: String[]) : void 
	/**
	 * 
	 * @Description 主界面显示及控制方法
	 * @author llystart
	 * @date 2022年12月8日下午10:43:58
	 */
	public void enterMainMenu() {
		boolean loopFlag = true;
		char menu = 0;
		while (loopFlag) {
			if (menu != '1') {
				listAllEmployees();
			}
			System.out.print("1-团队列表  2-添加团队成员  3-删除团队成员 4-退出   请选择(1-4)：");
			menu = TSUtility.readMenuSelection();
			switch (menu) {
			case '1':
				getTeam();
				break;
			case '2':
				addMember();
				break;
			case '3':
				deleteMember();
				break;
			case '4':
				System.out.print("确认是否退出(Y/N)：");
				char isExit = TSUtility.readConfirmSelection();
				if (isExit == 'y' || isExit == 'Y') {
					System.out.println("谢谢使用！");
					loopFlag = false;
					break;
				}
				break;

			}

		}
	}

	/**
	 * 
	 * @Description 以表格形式列出公司所有成员
	 * @author llystart
	 * @date 2022年12月8日下午10:44:08
	 */
	private void listAllEmployees() {
		System.out.println("显示公司所有的员工信息");
		System.out.println("\n-------------------------------开发团队调度软件--------------------------------\n");
		Employee[] employees = listSvc.getAllEmployees();
		if (employees == null || employees.length == 0) {
			System.out.println("公司中没有员工信息！");
		} else {
			System.out.println("ID\t姓名\t年龄\t工资\t职位\t状态\t奖金\t股票\t领用设备");
			for (int i = 0; i < employees.length; i++) {
				System.out.println(employees[i]);
			}
		}
		System.out.println("-------------------------------------------------------------------------------");
	}

	/**
	 * 
	 * @Description 显示团队成员列表操作
	 * @author llystart
	 * @date 2022年12月8日下午10:44:15
	 */
	private void getTeam() {
//		System.out.println("查看开发团队情况");
		System.out.println("--------------------团队成员列表---------------------");

		Programmer[] team = teamSvc.getTeam();
		if (team == null || team.length == 0) {
			System.out.println("开发团队目前没有成员！");
		} else {
			System.out.println("TID/ID\t姓名\t年龄\t工资\t职位\t奖金\t股票\n");
			for (int i = 0; i < team.length; i++) {
				System.out.println(team[i].getDetailsForTeam());
			}
		}
		System.out.println("-----------------------------------------------------");
	}

	/**
	 * 
	 * @Description 实现添加成员操作
	 * @author llystart
	 * @date 2022年12月8日下午10:44:20
	 */
	private void addMember() {
//		System.out.println("添加成员");
		System.out.print("---------------------添加成员---------------------\r\n" + "请输入要添加的员工ID：");
		int id = TSUtility.readInt();
		try {
			Employee emp = listSvc.getEmployee(id);
			teamSvc.addMember(emp);
			System.out.println("添加成功");
		} catch (TeamException e) {
			System.out.println("添加失败，原因：" + e.getMessage());
		}
		// 按回车继续...
		TSUtility.readReturn();

	}

	/**
	 * 
	 * @Description 实现删除成员操作
	 * @author llystart
	 * @date 2022年12月8日下午10:45:13
	 */
	private void deleteMember() {
//		System.out.println("删除成员");
		System.out.print("---------------------删除成员---------------------\r\n" + "请输入要删除员工的TID：");
		int memberId = TSUtility.readInt();
		System.out.print("确认是否删除(Y/N)：");
		char isDelete = TSUtility.readConfirmSelection();
		if(isDelete == 'n' || isDelete == 'N') {
			return;
		}
		try {
			teamSvc.removeMember(memberId);
			System.out.println("删除成功");
			TSUtility.readReturn();
		} catch (TeamException e) {
			System.out.println("删除失败，原因："+e.getMessage());
		}
		
	}

	public static void main(String[] args) {
		TeamView timeview = new TeamView();
		timeview.enterMainMenu();

	}

}
