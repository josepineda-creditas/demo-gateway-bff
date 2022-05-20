import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "2.6.7"
	id("io.spring.dependency-management") version "1.0.11.RELEASE"
	kotlin("jvm") version "1.6.21"
	kotlin("plugin.spring") version "1.6.21"
}

group = "mx.financial"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11

val detektVersion = "1.14.0"
val authLibVersion = "1.1.0-alpha.3"
//val kluentVersion = "1.61"
val awsSdkVersion = "1.11.997"
val retrofitVersion = "2.9.0"
val interceptorVersion = "3.9.0"
val openapiVersion = "1.5.9"

repositories {
	mavenCentral()
}

dependencies {
	// core
	implementation("org.springframework.boot:spring-boot-starter-actuator")
	implementation("org.springframework.boot:spring-boot-starter-webflux")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("io.projectreactor.kotlin:reactor-kotlin-extensions")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
	implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactor")

	// Retrofit
	implementation("com.squareup.retrofit2:retrofit:$retrofitVersion")
	implementation("com.squareup.retrofit2:converter-jackson:$retrofitVersion")
	implementation("com.squareup.okhttp3:logging-interceptor:$interceptorVersion")
	implementation("com.squareup.retrofit2:converter-scalars:$retrofitVersion")

	// validations
	implementation("org.springframework.boot:spring-boot-starter-validation")
	implementation("com.googlecode.libphonenumber:libphonenumber:8.12.30")

	// security
	implementation("org.springframework.boot:spring-boot-starter-security")


	// Tests
	testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test")
	//testImplementation("org.amshove.kluent:kluent:$kluentVersion")
	testImplementation("org.jetbrains.kotlin:kotlin-test-junit")
	testImplementation("io.projectreactor:reactor-test")
	testImplementation("org.springframework.boot:spring-boot-starter-test") {
		exclude(group = "org.junit.vintage", module = "junit-vintage-engine")
	}

//    Documentation
	implementation("org.springdoc:springdoc-openapi-webflux-ui:$openapiVersion")
	implementation("org.springdoc:springdoc-openapi-kotlin:$openapiVersion")

}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "11"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}
