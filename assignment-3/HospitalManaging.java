package com.oop;

import java.util.ArrayList;
import java.util.List;

class InvalidOperationException extends Exception {
    public InvalidOperationException(String message) {
        super(message);
    }
}

class Patient {
    private String name;
    private int age;
    private String medicalHistory;

    public Patient(String name, int age, String medicalHistory) {
        this.name = name;
        this.age = age;
        this.medicalHistory = medicalHistory;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getMedicalHistory() {
        return medicalHistory;
    }

    public void updateMedicalHistory(String newHistory) {
        this.medicalHistory = newHistory;
    }
}

// Class to represent a Doctor
class Doctor {
    private String name;
    private String specialization;

    public Doctor(String name, String specialization) {
        this.name = name;
        this.specialization = specialization;
    }

    public String getName() {
        return name;
    }

    public String getSpecialization() {
        return specialization;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Doctor doctor = (Doctor) obj;
        return name.equals(doctor.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode(); 
    }
}
class Appointment {
    private Patient patient;
    private Doctor doctor;
    private String date;
    private String time;

    public Appointment(Patient patient, Doctor doctor, String date, String time) {
        this.patient = patient;
        this.doctor = doctor;
        this.date = date;
        this.time = time;
    }

    public Patient getPatient() {
        return patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    @Override
    public String toString() {
        return "Appointment [Patient: " + patient.getName() + ", Doctor: " + doctor.getName() + ", Date: " + date + ", Time: " + time + "]";
    }
}
public class HospitalManaging {
    private List<Patient> patients;
    private List<Doctor> doctors;
    private List<Appointment> appointments;

    public HospitalManaging() {
        patients = new ArrayList<>();
        doctors = new ArrayList<>();
        appointments = new ArrayList<>();
    }

    public void addPatient(Patient patient) {
        patients.add(patient);
    }

    public void addDoctor(Doctor doctor) {
        doctors.add(doctor);
    }

    public void scheduleAppointment(Patient patient, Doctor doctor, String date, String time) throws InvalidOperationException {
        if (!patients.contains(patient)) {
            throw new InvalidOperationException("Patient not found.");
        }

        if (!doctors.contains(doctor)) {
            throw new InvalidOperationException("Doctor not found.");
        }

        Appointment appointment = new Appointment(patient, doctor, date, time);
        appointments.add(appointment);
    }

    public void displayAppointments() {
        if (appointments.isEmpty()) {
            System.out.println("No appointments scheduled.");
        } else {
            for (Appointment appointment : appointments) {
                System.out.println(appointment);
            }
        }
    }

    public static void main(String[] args) {
        HospitalManaging system = new HospitalManaging();
        Patient patient1 = new Patient("Harish", 30, "No significant history");
        Patient patient2 = new Patient("Balaji", 40, "Asthma");
        system.addPatient(patient1);
        system.addPatient(patient2);

        Doctor doctor1 = new Doctor("Dr. Sai Pradeep", "Cardiology");
        Doctor doctor2 = new Doctor("Dr. Rakesh", "Pulmonology");
        system.addDoctor(doctor1);
        system.addDoctor(doctor2);

        try {
            system.scheduleAppointment(patient1, doctor1, "2025-02-01", "10:00 AM");
            system.scheduleAppointment(patient2, doctor2, "2025-02-01", "11:00 AM");

            Doctor doctorNotInSystem = new Doctor("Dr. Vamsi", "Neurology");
            system.scheduleAppointment(patient1, doctorNotInSystem, "2025-02-01", "12:00 PM");
        } catch (InvalidOperationException e) {
            System.out.println("Error: " + e.getMessage());
        }

        system.displayAppointments();
    }
}
