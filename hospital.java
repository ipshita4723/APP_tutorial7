package doctor;
public class Doctor{
private int doctorId;
private String name;
private String specialisation;
private double consultationFee;
public Doctor(int doctorID,String name,String specialisation,double consultationFee){
this.doctorId=doctorId;
this.name=name;
this.speciaisation=specialisation;
this.consultationFee=consultationFee;
}
public String getSpecialization() {
        return specialization;
    }

public double getConsultationFee() {
        return consultationFee;
    }

public String getName() {
        return name;
    }

public void display() {
System.out.println("Doctor ID: " + doctorId + ", Name: " + name + ", Specialization: " + specialization + ", Fee: $" + consultationFee);
    }
}
package patient;

import doctor.Doctor;

public class Patient {
    private int patientId;
    private String name;
    private String disease;
    private int age;
    private Doctor assignedDoctor; // Holds the assigned doctor

    public Patient(int patientId, String name, String disease, int age) {
        this.patientId = patientId;
        this.name = name;
        this.disease = disease;
        this.age = age;
    }
    public void assignDoctor(Doctor d) {
        this.assignedDoctor = d;
    }

    public Doctor getAssignedDoctor() {
        return assignedDoctor;
    }

    public void display() {
        System.out.println("Patient ID: " + patientId + ", Name: " + name + 
                           ", Disease: " + disease + ", Age: " + age);
        if (assignedDoctor != null) {
            System.out.println("  -> Treated By: Dr. " + assignedDoctor.getName() + 
                               " (" + assignedDoctor.getSpecialization() + ")");
        } else {
            System.out.println("  -> No doctor assigned yet.");
        }
    }
}
public class hosptial {

    public static class Doctor {
        private int doctorId;
        private String name;
        private String specialization;
        private double consultationFee;

        public Doctor(int doctorId, String name, String specialization, double consultationFee) {
            this.doctorId = doctorId;
            this.name = name;
            this.specialization = specialization;
            this.consultationFee = consultationFee;
        }

        public int getDoctorId() { return doctorId; }
        public String getName() { return name; }
        public String getSpecialization() { return specialization; }
        public double getConsultationFee() { return consultationFee; }

        public void display() {
            System.out.println("Doctor ID: " + doctorId + " | Name: Dr. " + name + 
                               " | Specialization: " + specialization + 
                               " | Fee: $" + consultationFee);
        }
    }

    public static class Patient {
        private int patientId;
        private String name;
        private String disease;
        private int age;
        private Doctor assignedDoctor;

        public Patient(int patientId, String name, String disease, int age) {
            this.patientId = patientId;
            this.name = name;
            this.disease = disease;
            this.age = age;
            this.assignedDoctor = null;
        }

        public String getDisease() { return disease; }
        public Doctor getAssignedDoctor() { return assignedDoctor; }
        public void setAssignedDoctor(Doctor doctor) { this.assignedDoctor = doctor; }

        public void display() {
            System.out.println("Patient ID: " + patientId + " | Name: " + name + 
                               " | Age: " + age + " | Disease: " + disease);
            if (assignedDoctor != null) {
                System.out.println("   -> Assigned Doctor: Dr. " + assignedDoctor.getName() + 
                                   " (" + assignedDoctor.getSpecialization() + ")");
            } else {
                System.out.println("   -> Assigned Doctor: None");
            }
        }
    }

    public static void assignDoctor(Patient patient, Doctor[] doctors) {
        for (Doctor doc : doctors) {
            if (doc.getSpecialization().equalsIgnoreCase(patient.getDisease())) {
                patient.setAssignedDoctor(doc);
                return;
            }
        }
    }

    public static void main(String[] args) {
        Doctor[] doctors = {
            new Doctor(101, "Smith", "Cardiology", 150.0),
            new Doctor(102, "Adams", "Dermatology", 100.0)
        };

        Patient[] patients = {
            new Patient(1, "Alice", "Cardiology", 45),
            new Patient(2, "Bob", "Dermatology", 30),
            new Patient(3, "Charlie", "Cardiology", 60)
        };

        for (Patient p : patients) {
            assignDoctor(p, doctors);
        }
        for (Patient p : patients) {
            p.display();
        }
        for (Doctor doc : doctors) {
            int patientCount = 0;
            for (Patient p : patients) {
                if (p.getAssignedDoctor() != null && p.getAssignedDoctor().getDoctorId() == doc.getDoctorId()) {
                    patientCount++;
                }
            }
            double totalFee = patientCount * doc.getConsultationFee();
            System.out.println("Dr. " + doc.getName() + " (" + doc.getSpecialization() + ")");
            System.out.println("  - Patients Assigned: " + patientCount);
            System.out.println("  - Fee per Patient: $" + doc.getConsultationFee());
            System.out.println("  - Total Fee Collected: $" + totalFee);
        }
    }
}
