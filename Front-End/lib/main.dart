import 'package:flutter/material.dart';
import 'package:front_end/core/bindings.dart';
import 'package:front_end/view/login_view.dart';
import 'package:get/get_navigation/src/root/get_material_app.dart';
import 'package:get_storage/get_storage.dart';

Future<void> main() async {
  // Initialize GetStorage
  await GetStorage.init();

  // Run the app
  runApp(
    GetMaterialApp(
      initialBinding: AllBindings(),
      home: const LoginScreen(),
    ),
  );
}

