package ATripToParadise;
import java.io.Serializable;

import  ATripToParadise.allInterfaces.*;
public class ManipalCigna implements MedicalInsurance,Serializable {
	public void claimInsurance() {
		System.out.println("CLAIM PROCESS:\n");
		System.out.println("STEP 1: Before you seek medical treatment we request that you contact us 3 days in advance.\n This will allow our health relationship managers to help you follow the next few steps.\n In case of emergency, you can contact us within 24 hours of admission to the hospital.\n");
		System.out.println("STEP 2: At the network hospital you will need to show your ManipalCigna Health Insurance health card and valid photo ID to be able to use your insurance.\n This will give the network hospital the details they need to contact us for the cashless hospitalization process.\n");
		System.out.println("STEP 3: Hospital will send us the final request for authorization of any residual amount along with final hospital bill and discharge summary.\n You will be discharged from the hospital upon receipt of final authorization letter from us. Any inadmissible expenses, copayments, deductions will have to be paid by you.");
		System.out.println("STEP 4: Once the Hospitalization is done, hospital will send the original claim documents to us.\n The claim will be assessed by us and payment will be made to the network hospital");
		
	}
	public void reimbursement() {
		System.out.println("REIMBURSEMENT:\nUpon approval of claim by us, payment of the reimbursement claim will be made to the policy holder either through EFT or through cheque/DD.");
	}
	public void Admissionprocess() {
		System.out.println("ADMISSION PROCESS:\n At the network hospital you will need to show your ManipalCigna Health Insurance health card and valid photo ID to be able to use your insurance.");
	}
	public void policyType() {
		System.out.println("POLICY TYPE:\nYour policy is AAROGYA SANJEEVANI POLICY\n");
	}
}
