class UserLoginModel {
  String? jwt;
  int? id;
  String? lastName;
  String? password;
  String? firstName;
  String? username;
  String? email;
  String? role;
  String? address;
  String? phoneNumber;
  String? experience;
  String? salary;
  String? fidelity;

  UserLoginModel(
      {this.jwt,
      this.id,
      this.lastName,
      this.password,
      this.firstName,
      this.username,
      this.email,
      this.role,
      this.address,
      this.phoneNumber,
      this.experience,
      this.salary,
      this.fidelity});

  UserLoginModel.fromJson(Map<String, dynamic> json) {
    jwt = json['jwt'];
    id = json['id'];
    lastName = json['lastName'];
    password = json['password'];
    firstName = json['firstName'];
    username = json['username'];
    email = json['email'];
    role = json['role'];
    address = json['address'];
    phoneNumber = json['phoneNumber'];
    experience = json['experience'];
    salary = json['salary'];
    fidelity = json['fidelity'];
  }

  Map<String, dynamic> toJson() {
    final Map<String, dynamic> data = new Map<String, dynamic>();
    data['jwt'] = this.jwt;
    data['id'] = this.id;
    data['lastName'] = this.lastName;
    data['password'] = this.password;
    data['firstName'] = this.firstName;
    data['username'] = this.username;
    data['email'] = this.email;
    data['role'] = this.role;
    data['address'] = this.address;
    data['phoneNumber'] = this.phoneNumber;
    data['experience'] = this.experience;
    data['salary'] = this.salary;
    data['fidelity'] = this.fidelity;
    return data;
  }
}
