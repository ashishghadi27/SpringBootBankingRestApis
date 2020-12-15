package com.lti.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.lti.RestTemplateModels.RestAdminTemplate;
import com.lti.RestTemplateModels.RestCustRepresTemplate;
import com.lti.RestTemplateModels.RestServiceReferenceListTemplate;
import com.lti.RestTemplateModels.RestServiceReferenceTemplate;
import com.lti.RestTemplateModels.RestSimpleTemplate;
import com.lti.RestTemplateModels.RestUserObjectTemplate;
import com.lti.model.Address;
import com.lti.model.Admin;
import com.lti.model.CustomerRepres;
import com.lti.model.RegisterUser;
import com.lti.model.ServiceReference;

@Repository
public class AdminDaoImpl implements AdminDao {

	@Autowired
	private SessionFactory factory;

	public AdminDaoImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AdminDaoImpl(SessionFactory factory) {
		super();
		this.factory = factory;
	}

	public SessionFactory getFactory() {
		return factory;
	}

	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}

	@Override
	public ResponseEntity<RestServiceReferenceTemplate> generateServiceReference(ServiceReference sReference) {
		Session session = factory.getCurrentSession();
		session.save(sReference);
		RestServiceReferenceTemplate sReferenceTemplate;
		if (sReference.getServiceId() != null) {
			sReferenceTemplate = new RestServiceReferenceTemplate("success", "Service Reference Generated",
					HttpStatus.OK, sReference);
			return new ResponseEntity<RestServiceReferenceTemplate>(sReferenceTemplate, HttpStatus.OK);
		} else {
			sReferenceTemplate = new RestServiceReferenceTemplate("failed", "Service Reference Generation Failed",
					HttpStatus.INTERNAL_SERVER_ERROR, sReference);
			return new ResponseEntity<RestServiceReferenceTemplate>(sReferenceTemplate,
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@SuppressWarnings("rawtypes")
	@Override
	public ResponseEntity<RestSimpleTemplate> updateAdminAndCustRepres(String userId, String adminId, String cId) {
		Session session = factory.getCurrentSession();
		NativeQuery query = session.createSQLQuery(
				"update service_reference set adminId=" + adminId + ", cId=" + cId + " where userId=" + userId);
		int updated = query.executeUpdate();
		RestSimpleTemplate restSimpleTemplate;
		if (updated > 0) {
			restSimpleTemplate = new RestSimpleTemplate("success",
					"Admin Id and Customer Respresentative Id Updated Successfully", HttpStatus.OK);
			return new ResponseEntity<RestSimpleTemplate>(restSimpleTemplate, HttpStatus.OK);
		} else {
			restSimpleTemplate = new RestSimpleTemplate("failed",
					"Admin Id and Customer Respresentative Id Update Failed", HttpStatus.INTERNAL_SERVER_ERROR);
			return new ResponseEntity<RestSimpleTemplate>(restSimpleTemplate, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public ResponseEntity<RestSimpleTemplate> updateStatus(String userId, String status, String remark) {
		Session session = factory.getCurrentSession();
		@SuppressWarnings("rawtypes")
		NativeQuery query = session.createSQLQuery(
				"update service_reference set status='" + status + "', remark='" + remark + "' where userId=" + userId);
		int updated = query.executeUpdate();
		RestSimpleTemplate restSimpleTemplate;
		if (updated > 0) {
			restSimpleTemplate = new RestSimpleTemplate("success", "Status and Remark Id Updated Successfully",
					HttpStatus.OK);
			return new ResponseEntity<RestSimpleTemplate>(restSimpleTemplate, HttpStatus.OK);
		} else {
			restSimpleTemplate = new RestSimpleTemplate("failed", "Status and Remark Update Failed",
					HttpStatus.INTERNAL_SERVER_ERROR);
			return new ResponseEntity<RestSimpleTemplate>(restSimpleTemplate, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@SuppressWarnings("rawtypes")
	@Override
	public ResponseEntity<RestAdminTemplate> adminLogin(String username, String password) {
		Session session = factory.getCurrentSession();
		NativeQuery query = session.createSQLQuery(
				"select * from admin where username='" + username + "' and password='" + password + "'");
		query.addEntity(Admin.class);
		try {
			Admin admin = (Admin) query.getSingleResult();
			RestAdminTemplate restAdminTemplate = new RestAdminTemplate("success", "Admin Found", HttpStatus.OK, admin);
			return new ResponseEntity<RestAdminTemplate>(restAdminTemplate, HttpStatus.OK);

		} catch (Exception e) {
			RestAdminTemplate restAdminTemplate = new RestAdminTemplate("failed", "Invalid Credentials", HttpStatus.OK,
					null);
			return new ResponseEntity<RestAdminTemplate>(restAdminTemplate, HttpStatus.OK);
		}

	}

	@SuppressWarnings("rawtypes")
	@Override
	public ResponseEntity<RestCustRepresTemplate> customerRepresentativeLogin(String username, String password) {
		Session session = factory.getCurrentSession();
		NativeQuery query = session.createSQLQuery(
				"select * from cust_repres where username='" + username + "' and password='" + password + "'");
		query.addEntity(CustomerRepres.class);
		try {
			CustomerRepres customerRepres = (CustomerRepres) query.getSingleResult();
			RestCustRepresTemplate restCustRepresTemplate = new RestCustRepresTemplate("success",
					"Customer Representative Found", HttpStatus.OK, customerRepres);
			return new ResponseEntity<RestCustRepresTemplate>(restCustRepresTemplate, HttpStatus.OK);

		} catch (Exception e) {
			RestCustRepresTemplate restCustRepresTemplate = new RestCustRepresTemplate("failed", "Invalid Credentials",
					HttpStatus.OK, null);
			return new ResponseEntity<RestCustRepresTemplate>(restCustRepresTemplate, HttpStatus.OK);
		}
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public ResponseEntity<RestServiceReferenceListTemplate> getListOfServiceReference() {
		Session session = factory.getCurrentSession();
		NativeQuery query = session.createSQLQuery("select * from service_reference");
		query.addEntity(ServiceReference.class);
		List<ServiceReference> list = query.list();
		return new ResponseEntity<RestServiceReferenceListTemplate>(
				new RestServiceReferenceListTemplate("success", "All requests fetched", HttpStatus.OK, list),
				HttpStatus.OK);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public ResponseEntity<RestServiceReferenceListTemplate> getListOfServiceReferenceByAdmin(String adminId) {
		Session session = factory.getCurrentSession();
		NativeQuery query = session.createSQLQuery("select * from service_reference where adminId=" + adminId);
		query.addEntity(ServiceReference.class);
		List<ServiceReference> list = query.list();
		return new ResponseEntity<RestServiceReferenceListTemplate>(
				new RestServiceReferenceListTemplate("success", "All requests fetched", HttpStatus.OK, list),
				HttpStatus.OK);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public ResponseEntity<RestServiceReferenceListTemplate> getListOfServiceReferenceByCid(String cId) {
		Session session = factory.getCurrentSession();
		NativeQuery query = session.createSQLQuery("select * from service_reference where cId=" + cId);
		query.addEntity(ServiceReference.class);
		List<ServiceReference> list = query.list();
		return new ResponseEntity<RestServiceReferenceListTemplate>(
				new RestServiceReferenceListTemplate("success", "All requests fetched", HttpStatus.OK, list),
				HttpStatus.OK);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public ResponseEntity<RestUserObjectTemplate> getUserDetailsAndAccountDetails(String userId) {
		Session session = factory.getCurrentSession();
		RestUserObjectTemplate restUserObjectTemplate;
		try {
			NativeQuery query = session.createSQLQuery("select * from bankuser where userId=" + userId);
			query.addEntity(RegisterUser.class);
			RegisterUser user = (RegisterUser) query.getSingleResult();

			NativeQuery query2 = session.createSQLQuery("select * from address where userId=" + userId);
			query2.addEntity(Address.class);
			List<Address> addresses = (List<Address>) query2.list();
			restUserObjectTemplate = new RestUserObjectTemplate("success", "User Found", HttpStatus.OK, user,
					addresses);

		} catch (Exception e) {
			restUserObjectTemplate = new RestUserObjectTemplate("failed", "User Found", HttpStatus.OK, null, null);
		}
		return new ResponseEntity<RestUserObjectTemplate>(restUserObjectTemplate, HttpStatus.OK);

	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public ResponseEntity<RestServiceReferenceListTemplate> getListOfServiceReferenceByUserId(String userId) {
		Session session = factory.getCurrentSession();
		NativeQuery query = session.createSQLQuery("select * from service_reference where userId=" + userId);
		query.addEntity(ServiceReference.class);
		List<ServiceReference> list = query.list();
		return new ResponseEntity<RestServiceReferenceListTemplate>(
				new RestServiceReferenceListTemplate("success", "All requests fetched", HttpStatus.OK, list),
				HttpStatus.OK);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public ResponseEntity<RestSimpleTemplate> deleteServiceReference(String serviceId) {
		Session session = factory.getCurrentSession();
		NativeQuery query = session.createSQLQuery("delete from service_reference where serviceId=" + serviceId);
		int i = query.executeUpdate();
		if (i > 0) {
			return new ResponseEntity<RestSimpleTemplate>(
					new RestSimpleTemplate("success", "Deleted Successfully", HttpStatus.OK), HttpStatus.OK);
		} else {
			return new ResponseEntity<RestSimpleTemplate>(
					new RestSimpleTemplate("success", "Invalid Service Reference Number", HttpStatus.OK),
					HttpStatus.OK);
		}
	}

	@Override
	public ResponseEntity<RestSimpleTemplate> sendSMS(String email, String message) {

		if (MailSender.sendMail(message, email)) {
			return new ResponseEntity<RestSimpleTemplate>(new RestSimpleTemplate("success", "Mail Sent", HttpStatus.OK),
					HttpStatus.OK);
		} else {
			return new ResponseEntity<RestSimpleTemplate>(new RestSimpleTemplate("failed","SMS Not Sent", HttpStatus.OK), HttpStatus.OK);
		}

	}

	/*
	 * @Override public ResponseEntity<RestSimpleTemplate> sendSMS(String
	 * phoneNo, String message) { OkHttpClient client = new OkHttpClient();
	 * MediaType mediaType =
	 * MediaType.parse("application/x-www-form-urlencoded"); RequestBody body =
	 * RequestBody.create(mediaType, "{\n\t\"to\":\"" + phoneNo
	 * +"\",\n\t\"content\":\"" + message
	 * +"\",\n\t\"from\":\"SMSINFO\",\n\t\"dlr\":\"yes\",\n\t\"dlr-method\":\"GET\", \n\t\"dlr-level\":\"2\", \n\t\"dlr-url\":\"http://yourcustompostbackurl.com\"\n}"
	 * ); Request request = new Request.Builder()
	 * .url("https://rest-api.d7networks.com/secure/send") .method("POST", body)
	 * .addHeader("Content-Type", "application/x-www-form-urlencoded")
	 * .addHeader("Authorization", "Basic YnlzaTg3MjI6RGlsS2YxSWg=") .build();
	 * try { Response response = client.newCall(request).execute();
	 * System.out.println(response); return new
	 * ResponseEntity<RestSimpleTemplate>(new RestSimpleTemplate("success",
	 * "SMS Sent", HttpStatus.OK), HttpStatus.OK); } catch (IOException e) { //
	 * TODO Auto-generated catch block e.printStackTrace(); return new
	 * ResponseEntity<RestSimpleTemplate>(new RestSimpleTemplate("failed",
	 * "SMS Not Sent", HttpStatus.OK), HttpStatus.OK); } }
	 */

}
