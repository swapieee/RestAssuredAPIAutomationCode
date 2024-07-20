package api.endpoints;

public class Routes {
	
//	Create User - https://petstore.swagger.io/v2/user
//	Get User - https://petstore.swagger.io/v2/user/{username}
//	Update User - https://petstore.swagger.io/v2/user/{username}
//	Delete User - https://petstore.swagger.io/v2/user/{username}
	
	// BASE URL
	public static String base_url = "https://petstore.swagger.io/v2";

	// USER MODULE URLs
	public static String user_post_url = base_url + "/user";
	public static String user_get_url = base_url + "/user/{username}";
	public static String user_put_url = base_url + "/user/{username}";
	public static String user_del_url = base_url + "/user/{username}";
	
	// PET MODULE URLs
	
	// STORE MODULE URLs

}
