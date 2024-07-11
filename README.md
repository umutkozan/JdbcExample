JDBC MySQL Example
Bu proje, JDBC kullanarak bir MySQL veritabanına bağlanan, "employees" adında bir tablo oluşturan ve bu tablodan veri çeken bir Java uygulamasını içermektedir.

Gerekli Adımlar
1. MySQL Veritabanı Kurulumu
İlk olarak, MySQL veritabanınızın kurulu ve çalışır durumda olduğundan emin olun. Ardından aşağıdaki SQL komutlarını kullanarak mydatabase adında bir veritabanı oluşturun ve employees tablosunu oluşturun:
sql
CREATE DATABASE IF NOT EXISTS mydatabase;
USE mydatabase;

CREATE TABLE IF NOT EXISTS employees (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    position VARCHAR(100) NOT NULL,
    salary DECIMAL(10, 2) NOT NULL
);

INSERT INTO employees (name, position, salary) VALUES
('John Doe', 'Software Engineer', 60000),
('Jane Smith', 'Project Manager', 75000),
('Mike Brown', 'Designer', 50000),
('Emily Davis', 'Data Scientist', 80000),
('James Wilson', 'QA Engineer', 55000);
2. Proje Yapılandırması
Projeyi oluşturduktan sonra, JDBC MySQL sürücüsünü projenize ekleyin. Maven kullanıyorsanız, pom.xml dosyanıza aşağıdaki bağımlılığı ekleyin:

xml
<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
    <version>8.0.23</version>
</dependency>
Eğer Maven kullanmıyorsanız, mysql-connector-java.jar dosyasını indirip projenizin lib klasörüne ekleyin ve proje yapılandırmasında bu jar dosyasını belirtin.
