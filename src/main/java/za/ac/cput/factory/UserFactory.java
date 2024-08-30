//package za.ac.cput.factory;
//
//import za.ac.cput.domain.User;
//import za.ac.cput.util.Helper;
//
//public class UserFactory {
//    public static User buildUser(long userId, String email, String password){
//
//        if(Helper.emailIsValid(email, "^(.+)@(\\S+)$") || Helper.isNullOrEmpty(password))
//            return null;
//
//        return new User.Builder()
//                .setUserId(userId)
//                .setEmail(email)
//                .setPassword(password)
//                .build();
//    }
//}
