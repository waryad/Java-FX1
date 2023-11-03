/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javafxapplication4;

/**
 *
 * @author owner
 */
class Student  implements java.io.Serializable
{
    String  name;
    int     id;
    double  gpa;

    public Student(String name, int id, double gpa)
    {
        this.name = name;
        this.id   = id;
        this.gpa  = gpa;
    }
}
