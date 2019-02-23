package com.city.coding2.waiterassistant;

public class table {

    private int tableNum;
    private int tableGuestNum ;
    private int tableCapacity;
    private boolean tableState;

    public table(int tableNum, int tableGuestNum, int tableCapacity, boolean tableState) {
        this.tableNum = tableNum;
        this.tableGuestNum = tableGuestNum;
        this.tableCapacity = tableCapacity;
        this.tableState = tableState;
    }

    public int getTableNum() {
        return tableNum;
    }

    public int getTableGuestNum() {
        return tableGuestNum;
    }

    public int getTableCapacity() {
        return tableCapacity;
    }

    public boolean isTableState() {
        return tableState;
    }

    public void setTableNum(int tableNum) {
        this.tableNum = tableNum;
    }

    public void setTableGuestNum(int tableGuestNum) {
        this.tableGuestNum = tableGuestNum;
    }

    public void setTableCapacity(int tableCapacity) {
        this.tableCapacity = tableCapacity;
    }

    public void setTableState(boolean tableState) {
        this.tableState = tableState;
    }
}
