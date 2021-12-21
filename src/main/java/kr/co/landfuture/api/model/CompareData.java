package kr.co.landfuture.api.model;

public class CompareData {
        public static OutAbi[] ABIS = {

                        new OutAbi("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15",
                                        "16", "17") };

        public static OutJobtype[] JOBTYPES = { new OutJobtype(1, "Angular for Beginners",
                        "https://angular-academy.s3.amazonaws.com/thumbnails/angular2-for-beginners-small-v2.png",
                        "https://angular-academy.s3.amazonaws.com/main-logo/main-page-logo-small-hat.png",
                        "Establish a solid layer of fundamentals, learn what's under the hood of Angular", "BEGINNER",
                        10),

                        new OutJobtype(2, "Angular Security Course - Web Security Fundamentals",
                                        "Learn Web Security Fundamentals and apply them to defend an Angular / Node Application from multiple types of attacks.",
                                        "https://s3-us-west-1.amazonaws.com/angular-university/course-images/security-cover-small-v2.png",
                                        "https://s3-us-west-1.amazonaws.com/angular-university/course-images/lock-v2.png",
                                        "ADVANCED", 10),

                        new OutJobtype(3, "Angular PWA - Progressive Web Apps Course",
                                        "<p class='course-description'>Learn Angular Progressive Web Applications, build the future of the Web Today.",
                                        "https://s3-us-west-1.amazonaws.com/angular-university/course-images/angular-pwa-course.png",
                                        "https://s3-us-west-1.amazonaws.com/angular-university/course-images/alien.png",
                                        "ADVANCED", 10),

                        new OutJobtype(4, "Angular NgRx Store Reactive Extensions Architecture Course",
                                        "Learn how to the Angular NgRx Reactive Extensions and its Tooling to build a complete application.",
                                        "https://angular-academy.s3.amazonaws.com/thumbnails/ngrx-angular.png",
                                        "https://angular-academy.s3.amazonaws.com/thumbnails/ngrx-small.png",
                                        "ADVANCED", 10),

        };
        public static OutCourse[] COURSES = { new OutCourse(1, "Angular for Beginners",
                        "https://angular-academy.s3.amazonaws.com/thumbnails/angular2-for-beginners-small-v2.png",
                        "https://angular-academy.s3.amazonaws.com/main-logo/main-page-logo-small-hat.png",
                        "Establish a solid layer of fundamentals, learn what's under the hood of Angular", "BEGINNER"),

                        new OutCourse(2, "Angular Security Course - Web Security Fundamentals",
                                        "Learn Web Security Fundamentals and apply them to defend an Angular / Node Application from multiple types of attacks.",
                                        "https://s3-us-west-1.amazonaws.com/angular-university/course-images/security-cover-small-v2.png",
                                        "https://s3-us-west-1.amazonaws.com/angular-university/course-images/lock-v2.png",
                                        "ADVANCED"),

                        new OutCourse(3, "Angular PWA - Progressive Web Apps Course",
                                        "<p class='course-description'>Learn Angular Progressive Web Applications, build the future of the Web Today.",
                                        "https://s3-us-west-1.amazonaws.com/angular-university/course-images/angular-pwa-course.png",
                                        "https://s3-us-west-1.amazonaws.com/angular-university/course-images/alien.png",
                                        "ADVANCED"),

                        new OutCourse(4, "Angular NgRx Store Reactive Extensions Architecture Course",
                                        "Learn how to the Angular NgRx Reactive Extensions and its Tooling to build a complete application.",
                                        "https://angular-academy.s3.amazonaws.com/thumbnails/ngrx-angular.png",
                                        "https://angular-academy.s3.amazonaws.com/thumbnails/ngrx-small.png",
                                        "ADVANCED"),

                        new OutCourse(5, "Angular Advanced Library Laboratory: Build Your Own Library",
                                        "Learn Advanced Angular functionality typically used in Library Development. Advanced Components, Directives, Testing, Npm",
                                        "https://angular-academy.s3.amazonaws.com/thumbnails/advanced_angular-small-v3.png",
                                        "https://angular-academy.s3.amazonaws.com/thumbnails/angular-advanced-lesson-icon.png",
                                        "ADVANCED"),

                        new OutCourse(6, "The Complete Typescript Course",
                                        "Complete Guide to Typescript From Scratch: Learn the language in-depth and use it to build a Node REST API.",
                                        "https://angular-academy.s3.amazonaws.com/thumbnails/typescript-2-small.png",
                                        "https://angular-academy.s3.amazonaws.com/thumbnails/typescript-2-lesson.png",
                                        "BEGINNER"),

                        new OutCourse(7, "Rxjs and Reactive Patterns Angular Architecture Course",
                                        "Learn the core RxJs Observable Pattern as well and many other Design Patterns for building Reactive Angular Applications.",
                                        "https://s3-us-west-1.amazonaws.com/angular-academy/blog/images/rxjs-reactive-patterns-small.png",
                                        "https://angular-academy.s3.amazonaws.com/course-logos/observables_rxjs.png",
                                        "BEGINNER"),

                        new OutCourse(8, "Angular Material Course",
                                        "https://s3-us-west-1.amazonaws.com/angular-university/course-images/material_design.png",
                                        "https://s3-us-west-1.amazonaws.com/angular-university/course-images/material_design.png",
                                        "Build Applications with the official Angular Widget Library", "ADVANCED"

                        ) };
        public static OutLesson[] LESSONS = {

                        new OutLesson(1, "Building Your First  Component - Component Composition", "2:07", 1, 1),
                        new OutLesson(2, "Building Your First  Component - Component Composition", "2:07", 2, 1),
                        new OutLesson(3, "Component @Input - How To Pass Input Data To an  Component", "2:33", 3, 1),
                        new OutLesson(4, " Component Events - Using @Output to create custom events", "4:44", 4, 1),
                        new OutLesson(5, " Component Templates - Inline Vs External", "2:55", 5, 1),
                        new OutLesson(6, "Styling  Components - Learn About Component Style Isolation", "3:27", 6, 1),
                        new OutLesson(7, " Component Interaction - Extended Components Example", "9:22", 7, 1),
                        new OutLesson(8, " Components Tutorial For Beginners - Components Exercise !", "1:26", 8, 1),
                        new OutLesson(9, " Components Tutorial For Beginners - Components Exercise Solution Inside",
                                        "2:08", 9, 1),
                        new OutLesson(10,
                                        " Directives - Inputs, Output Event Emitters and How To Export Template References",
                                        "4:01", 10, 1),
                        new OutLesson(11, " Helicopter View", "08:19", 1, 2),
                        new OutLesson(12, "Installing Git, Node, NPM and Choosing an IDE", "04:17", 2, 2),
                        new OutLesson(13, "Installing The Lessons Code - Learn Why Its Essential To Use NPM 5", "06:05",
                                        3, 2),
                        new OutLesson(14, "How To Run Node In TypeScript With Hot Reloading", "03:57", 4, 2),
                        new OutLesson(15, "Guided Tour Of The Sample Application", "06:00", 5, 2),
                        new OutLesson(16, "Client Side Authentication Service - API Design", "04:53", 6, 2),
                        new OutLesson(17, "Client Authentication Service - Design and Implementation", "09:14", 7, 2),
                        new OutLesson(18, "The New Angular HTTP Client - Doing a POST Call To The Server", "06:08", 8,
                                        2),
                        new OutLesson(19, "User Sign Up Server-Side Implementation in Express", "08:50", 9, 2),
                        new OutLesson(20, "Introduction To Cryptographic Hashes - A Running Demo", "05:46", 10, 2),
                        new OutLesson(21, "Some Interesting Properties Of Hashing Functions - Validating Passwords",
                                        "06:31", 11, 2),
                        new OutLesson(22, " Kick-Off - Install Node, NPM, IDE And Service Workers Section Code",
                                        "07:19", 1, 3),
                        new OutLesson(23, "Service Workers In a Nutshell - Service Worker Registration", "6:59", 2, 3),
                        new OutLesson(24, "Service Workers Hello World - Lifecycle Part 1 and PWA Chrome Dev Tools",
                                        "7:28", 3, 3),
                        new OutLesson(25,
                                        "Service Workers and Application Versioning - Install & Activate Lifecycle Phases",
                                        "10:17", 4, 3),
                        new OutLesson(26, "Downloading The Offline Page - The Service Worker Installation Phase",
                                        "09:50", 5, 3),
                        new OutLesson(27, "Introduction to the Cache Storage PWA API", "04:44", 6, 3),
                        new OutLesson(28, "View Service Workers HTTP Interception Features In Action", "06:07", 7, 3),
                        new OutLesson(29, "Service Workers Error Handling - Serving The Offline Page", "5:38", 8, 3) };
}
