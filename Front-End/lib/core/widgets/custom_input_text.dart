import 'package:flutter/material.dart';
class CustomInputText extends StatelessWidget {

  final TextEditingController? controller;
  final String? Function(String?)? validator;
  final String? text;
  final String? hintText;
  final IconData? icon;
  final Widget? suffixIcon;
  final bool? obscureText;
  
  const CustomInputText(
      {super.key,
      this.controller,
      this.validator,
      this.text,
      this.hintText,
      this.icon,
      this.suffixIcon,
      this.obscureText});
  @override
  Widget build(BuildContext context) {
    return TextFormField(
      controller: controller,
      validator: validator,
      decoration: InputDecoration(
        label: Text(
          "$text",
        ),
        hintText: "$hintText",
        border: const OutlineInputBorder(),
        prefixIcon: Icon(
          icon,
          color: Colors.blue,
        ),
        suffix: suffixIcon,
      ),
      obscureText: obscureText ?? false,
    );
  }
}