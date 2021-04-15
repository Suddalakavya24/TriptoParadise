package ATripToParadise;
import java.io.Serializable;

import ATripToParadise.allInterfaces.*;

public class Starhealth implements MedicalInsurance,Serializable {
	public void claimInsurance() {
		System.out.println("CLAIM PROCESS:\nFirst of all, find a Star Health network hospital in a city where you want to get cashless treatment.\n Intimate Star Health within 24 hours in emergency hospitalis ation and 48 hours before admission in case of planned hospitalisation.\n");
	}
	public void reimbursement() {
		System.out.println(" REIMBURSEMENT:\nIf cashless claim denied, then the insured can file for reimbursement claim after discharge.\n");
	}
	public void Admissionprocess() {
		System.out.println("ADMISSION PROCESS:\n While visiting a network hospital, carry your Star Health ID card and one photo ID proof.\n Fill the pre-authorization request form available at the hospital and submit it to the hospital.\n After your identity is checked, the network hospital sends the pre-authorization request form to Star Health.\n Once the insurer reviews the documents, it sends an approval letter to the hospital.\n Thus, you will be able to proceed with the cashless treatment at the hospital.\n");
	}
	public void policyType() {
		System.out.println("POLICY TYPE:\nYour plan is FAMILY PLAN\n");
	}
}
