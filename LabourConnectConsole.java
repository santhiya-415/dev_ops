import java.util.*;
class Labour {
    String name;
    String skill;
    String location;

    Labour(String name, String skill, String location) {
        this.name = name;
        this.skill = skill;
        this.location = location;
    }
}

class Job {
    String employerName;
    String requiredSkill;
    String location;
    String jobDescription;

    Job(String employerName, String requiredSkill, String location, String jobDescription) {
        this.employerName = employerName;
        this.requiredSkill = requiredSkill;
        this.location = location;
        this.jobDescription = jobDescription;
    }
}

public class LabourConnectConsole {
    static Scanner scanner = new Scanner(System.in);
    static List<Labour> labourList = new ArrayList<>();
    static List<Job> jobList = new ArrayList<>();

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n---- LabourConnect Job Finder ----");
            System.out.println("1. Register Labour");
            System.out.println("2. Register Employer & Post Job");
            System.out.println("3. Show All Jobs");
            System.out.println("4. Match Jobs to Labour Skill");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    registerLabour();
                    break;
                case 2:
                    postJob();
                    break;
                case 3:
                    showJobs();
                    break;
                case 4:
                    matchJobs();
                    break;
                case 5:
                    System.out.println("Thank you for using LabourConnect!");
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    static void registerLabour() {
        System.out.print("Enter Labour Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Skill (e.g., mason, painter): ");
        String skill = scanner.nextLine();
        System.out.print("Enter Location: ");
        String location = scanner.nextLine();

        Labour labour = new Labour(name, skill.toLowerCase(), location.toLowerCase());
        labourList.add(labour);
        System.out.println("Labour registered successfully!");
    }

    static void postJob() {
        System.out.print("Enter Employer Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Required Skill: ");
        String skill = scanner.nextLine();
        System.out.print("Enter Job Location: ");
        String location = scanner.nextLine();
        System.out.print("Enter Job Description: ");
        String desc = scanner.nextLine();

        Job job = new Job(name, skill.toLowerCase(), location.toLowerCase(), desc);
        jobList.add(job);
        System.out.println("Job posted successfully!");
    }

    static void showJobs() {
        if (jobList.isEmpty()) {
            System.out.println("No jobs available currently.");
            return;
        }
        System.out.println("\n--- Available Jobs ---");
        for (Job job : jobList) {
            System.out.println("Employer: " + job.employerName);
            System.out.println("Skill Required: " + job.requiredSkill);
            System.out.println("Location: " + job.location);
            System.out.println("Description: " + job.jobDescription);
            System.out.println("---------------------------");
        }
    }

    static void matchJobs() {
        System.out.print("Enter Labour Skill to Match: ");
        String skill = scanner.nextLine().toLowerCase();

        boolean found = false;
        for (Job job : jobList) {
            if (job.requiredSkill.equals(skill)) {
                found = true;
                System.out.println("Employer: " + job.employerName);
                System.out.println("Location: " + job.location);
                System.out.println("Description: " + job.jobDescription);
                System.out.println("---------------------------");
            }
        }

        if (!found) {
            System.out.println("No matching jobs found.");
        }
    }
}
