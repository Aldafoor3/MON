import 'package:front_end/core/storage/storage.dart';

class AppStorage {
  static String keyUsername = "username";
  static String keyEmail = "email";

  static saveUsername(String username) {
    SecureStorage.writeSecureData(key: keyUsername, value: username);
  }

  static String? readUserName() {
    String? username = SecureStorage.readSecureData(keyUsername);
    return username;
  }

  static saveEmail(String email) {
    SecureStorage.writeSecureData(key: keyEmail, value: email);
  }

  static String? readEmail() {
    String? email = SecureStorage.readSecureData(keyEmail);
    return email;
  }
}
