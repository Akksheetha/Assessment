import re
class InvalidFieldError(Exception):
    def __init__(self, field_name, value):
        self.field_name = field_name
        self.value = value
    def __str__(self):
        return f"Invalid {self.field_name}: {self.value}"
def validate_email(email):
    if not re.fullmatch(r"[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,5}", email):
        raise InvalidFieldError("Email", email)
    return True
def validate_phone(phone):
    if not re.fullmatch(r"[6-9]\d{9}", phone):
        raise InvalidFieldError("Phone", phone)
    return True
def validate_usn(usn):
    if not re.fullmatch(r"25MCA\d{3}", usn):
        raise InvalidFieldError("USN", usn)
    return True
