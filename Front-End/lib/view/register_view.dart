import 'package:dio/dio.dart';
import 'package:flutter/material.dart';
import 'package:front_end/core/networking/app_url.dart';
import 'package:front_end/core/widgets/custom_input_text.dart';

// ignore: must_be_immutable
class RegisterView extends StatelessWidget {
  RegisterView({super.key});

  final GlobalKey<FormState> formKey = GlobalKey<FormState>();
  final TextEditingController firstNameController = TextEditingController();
  final TextEditingController lastNameController = TextEditingController();
  final TextEditingController usernameController = TextEditingController();
  final TextEditingController emailController = TextEditingController();
  final TextEditingController passwordController = TextEditingController();
  final TextEditingController addressController = TextEditingController();
  final TextEditingController phoneNumberController = TextEditingController();
  final Dio dio = Dio();

  registerUser() async {
    try {
      Response response = await dio.post(
        AppUrl.registerUrl,
        data: {
          "firstName": firstNameController.text,
          "lastName": lastNameController.text,
          "username": usernameController.text,
          "email": emailController.text,
          "password": passwordController.text,
          "address": addressController.text,
          "phoneNumber": phoneNumberController.text,
        },
      );
      if (response.statusCode == 200) {
        print("Registration successful");
      } else {
        print("Registration failed");
      }
    } catch (error) {
      print('Error: $error');
    }
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: Center(
        child: Padding(
          padding: const EdgeInsets.all(20.0),
          child: Form(
            key: formKey,
            child: SingleChildScrollView(
              padding: EdgeInsets.all(20.0),
              child: Column(
                mainAxisAlignment: MainAxisAlignment.center,
                crossAxisAlignment: CrossAxisAlignment.stretch,
                children: [
                  const Text(
                    "Sign Up",
                    style: TextStyle(
                      fontSize: 24,
                      color: Colors.blue,
                      fontWeight: FontWeight.bold,
                    ),
                    textAlign: TextAlign.center,
                  ),
                  const SizedBox(height: 30),
                  CustomInputText(
                    controller: firstNameController,
                    hintText: "Enter your first name",
                    icon: Icons.person,
                    text: "First Name",
                    validator: (value) {
                      if (value!.isEmpty) {
                        return "First name is required";
                      }
                      return null;
                    },
                  ),
                  const SizedBox(height: 20),
                  CustomInputText(
                    controller: lastNameController,
                    hintText: "Enter your last name",
                    icon: Icons.person_outline,
                    text: "Last Name",
                    validator: (value) {
                      if (value!.isEmpty) {
                        return "Last name is required";
                      }
                      return null;
                    },
                  ),
                  const SizedBox(height: 20),
                  CustomInputText(
                    controller: usernameController,
                    hintText: "Enter your username",
                    icon: Icons.account_circle,
                    text: "Username",
                    validator: (value) {
                      if (value!.isEmpty) {
                        return "Username is required";
                      }
                      return null;
                    },
                  ),
                  const SizedBox(height: 20),
                  CustomInputText(
                    controller: emailController,
                    hintText: "Enter your email",
                    icon: Icons.email,
                    text: "Email",
                    validator: (value) {
                      if (value!.isEmpty) {
                        return "Email is required";
                      } else if (!RegExp(r'^[^@]+@[^@]+\.[^@]+').hasMatch(value)) {
                        return "Invalid email format";
                      }
                      return null;
                    },
                  ),
                  const SizedBox(height: 20),
                  CustomInputText(
                    controller: passwordController,
                    hintText: "Enter your password",
                    icon: Icons.lock,
                    obscureText: true,
                    suffixIcon: IconButton(
                      onPressed: () {},
                      icon: const Icon(
                        Icons.visibility,
                        color: Colors.blue,
                      ),
                    ),
                    text: "Password",
                    validator: (value) {
                      if (value!.isEmpty) {
                        return "Password is required";
                      } else if (value.length < 8) {
                        return "Password must be at least 8 characters";
                      }
                      return null;
                    },
                  ),
                  const SizedBox(height: 20),
                  CustomInputText(
                    controller: addressController,
                    hintText: "Enter your address",
                    icon: Icons.home,
                    text: "Address",
                    validator: (value) {
                      if (value!.isEmpty) {
                        return "Address is required";
                      }
                      return null;
                    },
                  ),
                  const SizedBox(height: 20),
                  CustomInputText(
                    controller: phoneNumberController,
                    hintText: "Enter your phone number",
                    icon: Icons.phone,
                    text: "Phone Number",
                    validator: (value) {
                      if (value!.isEmpty) {
                        return "Phone number is required";
                      } else if (!RegExp(r'^\d{10}$').hasMatch(value)) {
                        return "Invalid phone number";
                      }
                      return null;
                    },
                  ),
                  const SizedBox(height: 20),
                  ElevatedButton(
                    onPressed: () {
                      if (formKey.currentState!.validate()) {
                        registerUser();
                      }
                    },
                    style: ElevatedButton.styleFrom(
                      backgroundColor: Colors.green,
                      padding: EdgeInsets.symmetric(horizontal: 50, vertical: 15),
                    ),
                    child: const Text(
                      "Sign Up",
                      style: TextStyle(color: Colors.white),
                    ),
                  ),
                ],
              ),
            ),
          ),
        ),
      ),
    );
  }
}
