package student.model;

import java.util.Arrays;
import java.util.List;

public class StudentBean {
		private String id;
		private String name;
		private String dob;
		private String gender;
		private String phone;
		private String education;
		private List<String> attend;
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getDob() {
			return dob;
		}
		public void setDob(String dob) {
			this.dob = dob;
		}
		public String getGender() {
			return gender;
		}
		public void setGender(String gender) {
			this.gender = gender;
		}
		public String getPhone() {
			return phone;
		}
		public void setPhone(String phone) {
			this.phone = phone;
		}
		public String getEducation() {
			return education;
		}
		public void setEducation(String education) {
			this.education = education;
		}
		
		
		public StudentBean() {
			
		}
		public StudentBean(String id, String name, String dob, String gender, String phone, String education,
				List<String> attend) {
			super();
			this.id = id;
			this.name = name;
			this.dob = dob;
			this.gender = gender;
			this.phone = phone;
			this.education = education;
			this.attend = attend;
		}
		@Override
		public String toString() {
			return "id=" + id + ", name=" + name + ", dob=" + dob + ", gender=" + gender + ", phone="
					+ phone + ", education=" + education ;
		}
		public List<String> getAttend() {
			return attend;
		}
		public void setAttend(List<String> attend) {
			this.attend = attend;
		}
		
		


}
