## 📝 About

<div align="justify">
Notes is a web app for creating, deploying and sharing notes. Easly manage and organize
all your notes so you can share them with other Notes partners.
</div>

## ⚙️ Features

### Guests 👥

```
+_____________________________+
| Blok   | Notes  |    Editor   |
|_____________________________|
|        |        |                |
|        |        |                |
|        |        |                |
.        .        .                .
.        .        .                .
```

<!-- As they cannot save changes and are limited to sessions, Guests work on one 
Blok. They may have as much Notes as they wish. They are limited to Print or Export
to PDF, seperate Notes or a whole Blok (no sharing). They may use all the tools for
typography (fonts, colors, bullets, lists, spell check). They may import tables, files,
pictures, URL-s, symbols to their Notes. Drawing is also enabled. -->

- have one Blok
- export Blok/Notes to PDF
- are limited to Guest Editor features
- are limited to the duration of the session

### User 👤

```
+_____________________________+
|       Blok       |               |
|_____________________________|
| Section | Notes  |  Editor    |
|_____________________________|
|        |        |                |
|        |        |                |
|        |        |                |
.        .        .                .
.        .        .                .
```

- may have many Bloks
- are able to share Bloks and Notes 
- may enable syntax checking

### User Story 🗣️

<div align="justify">
As a hotel manager, I want to organize guest information and hotel operations into categories and subcategories so that we can efficiently manage our services and enhance the guest experience. For example, I want to group information under main categories like "Reservations" or "Guest Services," and break them down further, such as "VIP Guests" under "Reservations" or "Room Maintenance" under "Housekeeping."

I’d like to view these categories in a tree-like structure where staff can easily expand or collapse sections. I want to be able to add, rename, move, or delete categories with ease and assign colors or icons to them for quick identification. Additionally, I want to link guest preferences to their profiles to ensure that all staff members have access to relevant information.

The ability to search, filter, and sort through information is crucial, as well as organizing templates for common requests that automatically create subcategories. When generating reports or analyzing data, I want the structure to be preserved.

In short, this system will help us manage our hotel operations efficiently, making it easier to provide exceptional service to our guests.
</div>


### Development idea 🗣️

<div align="justify">
Each user has their own account, which contains notes and notifications that can be customized according to their needs. Notes and notifications can have a many-to-many relationship, meaning one notification can be linked to multiple notes and vice versa. Additionally, users can share a specific combination of notes and notifications with other users.

Users are also able to organize content into different categories, such as "School," "Work," "Personal," and more, to manage their information more easily. These categories can be organized in a tree-like pattern, allowing for subcategories under main categories. For example, users can organize "School" by different subjects such as "Math," "Science," or "History," and "Work" by project names or specific tasks, creating a structured hierarchy for better management of their information.

There is a planned implementation of customization features for the visual interface, such as adjusting colors to the user's preference, changing fonts, and, with sufficient resources, the addition of basic themes for the interface's appearance. For instance, users could choose between rounded and angular design elements.

The user logs into their account (or creates one). A selection of templates is offered upon login. If the user does not choose a template, they are taken to an empty template predefined in the application. The user can print the created file, save it as a PDF, or share it with others.

The main screen is divided into sections for paragraphs, pages, and an editor. In the editor, all basic text manipulation functions are enabled, including font formatting, lists, styles, and syntax checking. It is possible to add tables, files, images, links, symbols, emoticons, and audio. The user can view all created paragraphs, search through them, and delete them.
</div>

## 🗄️ Database

Model baze.
Tablica:

Korisnici (Users),

Bilješke (Notes),

Obavijesti (Notifications),

Kategorije (Categories),

Povezanost Bilješki i Obavijesti (Note_Notification),

Dijeljeni sadržaji (Shared_Items),

Teme (Themes),

## 📌 Tasks

1. README ⌛️

Boris:  
- (README) List out features for Guests and Users ⌛️
- (README) Create an example Database ⌛️

Silvestar:  
- (personal) Set-up working environment (IntelliJ IDEA and Git) ⌛️
- (README) Write an Example User Story ⌛️

## 🎓 Authors

Developed by [*chora7*](https://github.com/chora7) and [*salveta96*](https://github.com/salveta96).

## ⚖️  License

For more information check the [LICENSE](LICENSE) file.
