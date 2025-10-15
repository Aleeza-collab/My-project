#include<iostream>
#include<iomanip>
#include<limits>
using namespace std;

// Convert % to GPA Point 
double getGPAFromPercentage(double percentage) {
    if (percentage >= 85) return 4.0;
    else if (percentage >= 80) return 3.7;
    else if (percentage >= 75) return 3.3;
    else if (percentage >= 70) return 3.0;
    else if (percentage >= 65) return 2.7;
    else if (percentage >= 60) return 2.3;
    else if (percentage >= 55) return 2.0;
    else if (percentage >= 50) return 1.7;
    else return 0.0;
}

// ===== THEORY METHOD =====
double calcTheoryPercentage(string subject) {
    double quiz_sum = 0, quiz_totals = 0;
    double assignment_sum = 0, assignment_totals = 0;
    double mids_marks = 0, mids_total = 0;
    double finals_marks = 0, finals_total = 0;

    cout << "\n================== QUIZZES ==================" << endl;
    for (int j = 0; j < 4; j++) {
        int q_total, q_marks;
        cout << "Enter total marks for quiz " << j + 1 << ": ";
        cin >> q_total;

        do {
            cout << "Enter obtained marks for quiz " << j + 1 << ": ";
            cin >> q_marks;
            if (q_marks > q_total || q_marks < 0) {
                cout << " Error: Obtained marks cannot be negative or greater than total marks. Please re-enter.\n";
            }
        } while (q_marks > q_total || q_marks < 0);

        quiz_totals += q_total;
        quiz_sum += q_marks;
    }
    double quiz_percent = (quiz_sum / quiz_totals) * 15;

    cout << "\n================== ASSIGNMENTS ==================" << endl;
    for (int k = 0; k < 4; k++) {
        int a_total, a_marks;
        cout << "Enter total marks for assignment " << k + 1 << ": ";
        cin >> a_total;

        do {
            cout << "Enter obtained marks for assignment " << k + 1 << ": ";
            cin >> a_marks;
            if (a_marks > a_total || a_marks < 0) {
                cout << "? Error: Obtained marks cannot be negative or greater than total marks. Please re-enter.\n";
            }
        } while (a_marks > a_total || a_marks < 0);

        assignment_totals += a_total;
        assignment_sum += a_marks;
    }
    double assignment_percent = (assignment_sum / assignment_totals) * 10;

    cout << "\n================== MIDS ==================" << endl;
    cout << "Enter total mids marks of " << subject << ": ";
    cin >> mids_total;
    do {
        cout << "Enter obtained mids marks of " << subject << ": ";
        cin >> mids_marks;
        if (mids_marks > mids_total || mids_marks < 0) {
            cout << "? Error: Obtained marks cannot be negative or greater than total marks. Please re-enter.\n";
        }
    } while (mids_marks > mids_total || mids_marks < 0);

    cout << "\n================== FINALS ==================" << endl;
    cout << "Enter total finals marks of " << subject << ": ";
    cin >> finals_total;
    do {
        cout << "Enter obtained finals marks of " << subject << ": ";
        cin >> finals_marks;
        if (finals_marks > finals_total || finals_marks < 0) {
            cout << "? Error: Obtained marks cannot be negative or greater than total marks. Please re-enter.\n";
        }
    } while (finals_marks > finals_total || finals_marks < 0);

    double mids_percent = (mids_marks / mids_total) * 25;
    double finals_percent = (finals_marks / finals_total) * 50;

    return quiz_percent + assignment_percent + mids_percent + finals_percent;
}

// ===== LAB METHOD =====
double calcLabPercentage(string subject) {
    double lab_assign_sum = 0, lab_assign_total = 0;
    double lab_mid_marks = 0, lab_mid_total = 0;
    double lab_final_marks = 0, lab_final_total = 0;

    cout << "\n================== LAB ASSIGNMENTS ==================" << endl;
    for (int a = 0; a < 4; a++) {
        int total, marks;
        cout << "Enter total marks for lab assignment " << a + 1 << ": ";
        cin >> total;

        do {
            cout << "Enter obtained marks for lab assignment " << a + 1 << ": ";
            cin >> marks;
            if (marks > total || marks < 0) {
                cout << "? Error: Obtained marks cannot be negative or greater than total marks. Please re-enter.\n";
            }
        } while (marks > total || marks < 0);

        lab_assign_total += total;
        lab_assign_sum += marks;
    }
    double lab_assign_percent = (lab_assign_sum / lab_assign_total) * 25;

    cout << "\n================== LAB MIDS ==================" << endl;
    cout << "Enter total lab mids marks of " << subject << ": ";
    cin >> lab_mid_total;
    do {
        cout << "Enter obtained lab mids marks of " << subject << ": ";
        cin >> lab_mid_marks;
        if (lab_mid_marks > lab_mid_total || lab_mid_marks < 0) {
            cout << "? Error: Obtained marks cannot be negative or greater than total marks. Please re-enter.\n";
        }
    } while (lab_mid_marks > lab_mid_total || lab_mid_marks < 0);

    cout << "\n================== LAB FINALS ==================" << endl;
    cout << "Enter total lab finals marks of " << subject << ": ";
    cin >> lab_final_total;
    do {
        cout << "Enter obtained lab finals marks of " << subject << ": ";
        cin >> lab_final_marks;
        if (lab_final_marks > lab_final_total || lab_final_marks < 0) {
            cout << "? Error: Obtained marks cannot be negative or greater than total marks. Please re-enter.\n";
        }
    } while (lab_final_marks > lab_final_total || lab_final_marks < 0);

    double lab_mids_percent = (lab_mid_marks / lab_mid_total) * 25;
    double lab_finals_percent = (lab_final_marks / lab_final_total) * 50;

    return lab_assign_percent + lab_mids_percent + lab_finals_percent;
}

// ===== MAIN PROGRAM =====
int main() {
    cout << "=================================== COMSATS GPA CALCULATOR ===================================" << endl;

    int n;
    cout << "Enter number of subjects: ";
    cin >> n;

    if (n <= 0) {
        cout << "? Error: Invalid number of subjects! Please enter a positive value." << endl;
        return 0;
    }

    double totalGPA = 0;
    int totalCredits = 0;

    cout << fixed << setprecision(2);

    for (int i = 0; i < n; i++) {
        string type, subject;
        int credits;
        cout << "\n\n=================================== SUBJECT " << i + 1 << " ===================================" << endl;
        cout << "Is your subject theory or lab?: ";
        cin >> type;
        cout << "Enter credit hours of your subject: ";
        cin >> credits;

        // Credit hours check
        if (credits <= 0) {
            cout << "Error: Credit hours must be positive. Skipping this subject.\n";
            continue;
        }

        cin.ignore(numeric_limits<streamsize>::max(), '\n');
        cout << "Enter your subject name: ";
        getline(cin, subject);

        double percentage = 0;
        if (type == "theory" || type == "Theory" || type == "THEORY") {
            percentage = calcTheoryPercentage(subject);
        } 
        else if (type == "lab" || type == "Lab" || type == "LAB") {
            double theoryPercent = calcTheoryPercentage(subject);
            double labPercent = calcLabPercentage(subject);
            percentage = (labPercent * 0.33) + (theoryPercent * 0.67);
            cout << "Theory %: " << theoryPercent << " | Lab %: " << labPercent << endl;
        } 
        else {
            cout << "? Error: Invalid subject type! Please enter 'theory' or 'lab'. Skipping..." << endl;
            continue;
        }

        double gpa = getGPAFromPercentage(percentage);
        totalGPA += gpa * credits;
        totalCredits += credits;

        cout << subject << " Percentage: " << percentage << "%\n";
        cout << "GPA of " << subject << ": " << gpa << endl;
    }

    double overallCGPA = (totalCredits > 0) ? totalGPA / totalCredits : 0.0;
    cout << "\nYour overall CGPA is: " << overallCGPA << endl;

    return 0;
}

