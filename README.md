# DevFlix

## Problem Statement

Are there ways to find movies on the internet? Yes, many in fact. However none of them allow you to search for them and build your watchlist in as many ways as DevFlix (that statement is not true but for the sake of the capstone I'm making it anyway).

Wanna search for the best movies from a certain director, actor, year, or country? DevFlix has you covered!

## Technical Solution

Create an application for finding the next movie you'll watch in the quickest way possible.

### Example

Charlie wants to watch a movie he heard of starring Johnny Depp thats about chocolate. Problem is he has no idea what the movie is called! Luckily he knows who directed the movie. With this information Charlie is watching Chocolat in no time!

## Types of Users

### Guest

A Guest user can look through the DevFlix's collection with no limitation

### Member

A Member can add movies to their watchlist and give ratings

### Admin

An Admin can add, update, and delete movies to, in, or from the collection

## Movies

- Title
- Director
- Top 3 Billed Actors
- Year of release
- Country of Origin
- Language
- Poster

## High Level Requirements

### Browse Movies (Guest | Member | Admin)

- Movies presented in card format with button that leads to detail page
- Can be found by:
	- Title
	- Director
	- Actor
	- Year
	- Country
	- Language

### Add to Watchlist (Member | Admin)

- Adds a new "watchlist" page on navbar for approved user types
- Adds a button to movie cards to add to watchlist

### Rate a Movie (Member | Admin)

- All users can see the rating of a movie
- Only approved user types can rate movies
	- Option to rate on detail page of selected movie

### Add, Update, and Delete Movies (Admin)

- The standard add, update, and delete functionality of the other projects

## Learning Goal

I will be using web scraping to get the inital data for my database. I will be scraping information from IMDb's top 250 movies list.