package com.atguigu.team.domain;

public class Architect extends Designer {
	private int stock;// 股票

	public Architect() {
		super();
	}

	public Architect(int id, String name, int age, double salary, Equipment equipment, double bonus, int stock) {
		super(id, name, age, salary, equipment, bonus);
		this.stock = stock;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

//	2	马化腾	32	18000.0	架构师	FREE	15000.0	2000	联想T4(6000.0)
	@Override
	public String toString() {
		return getDetais() + "\t架构师\t" + getStatus() + "\t" + getBonus() + "\t" + stock + "\t"
				+ getEquipment().getDescription();
	}

	public String getDetailsForTeam() {
		return getTeamBaseDetails() + "\t架构师\t" + getBonus() + "\t" + getStock();
	}
}
