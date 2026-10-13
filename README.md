AI-Powered Resume & Recruitment Review

A backend application built with Spring Boot, MySQL, and AI (RAG Architecture) to automate resume screening, c andidate matching, and recruitment feedback.

📌 Features

Resume Parsing & Review: Automatically extracts and evaluates candidate resumes.
Uses Groq LLM API to analyse resume
RESTful APIs: Provides secure endpoints for managing applicants, job postings, and review status.
Database Management: Uses Spring Data JPA and MySQL for reliable data persistence.
🛠️ Tech Stack Backend Framework: Java, Spring Boot, Spring Data JPA, Spring Security Database: MySQL AI / LLM Integration: Groq LLM Api Build Tool: Maven

🚀 Getting Started

Prerequisites

Ensure you have the following installed on your machine:
Java JDK 17 (or later)
MySQL Server
Maven
Git
Installation & Setup

Clone the repository: git clone https://github.com/Shiva-1436/Ai-powered-Resume-Review.git cd Ai-powered-Resume-Review
2.Configure Database & Environment Variables Update your application.properties with your database credentials and API keys:

url: jdbc:mysql://localhost:3306/mysql url of your db
username: YOUR_DATABASE_USERNAME
password: YOUR_DATABASE_PASSWORD
api: YOUR_APIKEY
Build the Application
Run the Application
🔗 API Endpoints

Method Endpoint Description POST /api/resumes/upload Upload a new resume for processing GET /api/resumes/{id}/review Retrieve AI analysis and score for a resume POST /api/resumes/history retrives resume history of previous submission
