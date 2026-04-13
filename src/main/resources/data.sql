-- Insert default roles if they don't exist
INSERT IGNORE INTO role (id, role_name) VALUES (1, 'ADMIN');
INSERT IGNORE INTO role (id, role_name) VALUES (2, 'EMPLOYEE');
INSERT IGNORE INTO role (id, role_name) VALUES (3, 'MANAGER');
INSERT IGNORE INTO role (id, role_name) VALUES (4, 'FINANCE');
INSERT IGNORE INTO role (id, role_name) VALUES (5, 'VENDOR');

-- Insert default department if it doesn't exist
INSERT IGNORE INTO department (id, dept_name) VALUES (1, 'Administration');

-- Insert default admin user if it doesn't exist
INSERT IGNORE INTO user (id, username, email, password, active, role_id, department_id) VALUES (1, 'Admin', 'admin@T.com', '123', true, 1, 1);
