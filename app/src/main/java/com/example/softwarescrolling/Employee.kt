package com.example.softwarescrolling

enum class Employee(var employee: String) {
    DEVELOPER("Разработчик"),
    ENGINEER("Инженер"),
    MANAGER("Менеджер"),
    TEACHER("Учитель");

    override fun toString(): String {
        return employee
    }
}