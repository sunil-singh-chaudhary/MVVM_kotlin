LiveData MVVM Architecture Example

The Main Concept of Using MVVM is that , we dont direactly Update the UI or XML file when we have new data instead of We Update ModelVIew and it will listen the update and Update the UI or XML 


Features

Displays a list of items using RecyclerView.
Utilizes LiveData to observe changes in the item list and automatically update the UI.
Demonstrates how ViewModel acts as a mediator between the UI and the data.

Clone the repository:
git clone https://github.com/sunil-singh-chaudhary/MVVM_kotlin.git


Code Overview

Item Model
The Item data class represents the model for each item in the list.
ViewModel
The ItemViewModel class serves as the ViewModel. It manages the data and business logic, exposing the item list through a LiveData property. The loadItems method simulates data loading.
MainActivity
The MainActivity observes changes in the itemList LiveData from the ViewModel and updates the RecyclerView's adapter accordingly.
ItemAdapter
The ItemAdapter extends ListAdapter and is responsible for inflating and binding the item layout to each item in the RecyclerView.
Layout Resources
The layout files (activity_main.xml and item_layout.xml) define the UI components' structure and appearance.

