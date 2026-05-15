package com.example.nammaselfskill

data class Course(
    val id: String,
    val title: String,
    val category: String,
    val duration: String,
    val centerName: String,
    val location: String,
    val jobGuarantee: Boolean,
    val startDate: String
)

val dummyCourses = listOf(
    Course("1", "Basic Electrician", "Electrician", "3 Months", "Govt ITI Mysore", "Mysore", true, "Oct 15, 2023"),
    Course("2", "Advanced Sewing & Tailoring", "Sewing", "2 Months", "Skill Center Mandya", "Mandya", false, "Nov 1, 2023"),
    Course("3", "Mobile Repairing", "Electrician", "3 Months", "PMKK Bangalore", "Bangalore", true, "Oct 20, 2023"),
    Course("4", "Python Programming", "Coding", "4 Months", "Digital Center Hubli", "Hubli", true, "Dec 5, 2023"),
    Course("5", "Data Entry Operator", "Coding", "2 Months", "Yuva Center Belgaum", "Belgaum", false, "Nov 10, 2023")
)
