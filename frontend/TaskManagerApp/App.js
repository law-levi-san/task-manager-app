import React, { useState, useEffect } from "react";
import {
  View,
  Text,
  TextInput,
  Button,
  FlatList,
  StyleSheet,
  Alert,
} from "react-native";
import API from "./api";

export default function App() {
  const [taskName, setTaskName] = useState("");
  const [description, setDescription] = useState("");
  const [tasks, setTasks] = useState([]);

  const fetchTasks = async () => {
    try {
      const res = await API.get("/getAllTasks");
      setTasks(res.data);
    } catch (err) {
      Alert.alert("Error", "Failed to fetch tasks");
    }
  };

  const handleAddTask = async () => {
    try {
      await API.post("/addTask", { taskName, description });
      setTaskName("");
      setDescription("");
      fetchTasks();
    } catch (err) {
      Alert.alert("Error", "Failed to add task");
    }
  };

  const handleMarkComplete = async (id) => {
    try {
      await API.put(`/markTaskAsCompleted/${id}`);
      fetchTasks();
    } catch (err) {
      Alert.alert("Error", "Failed to mark task as completed");
    }
  };

  useEffect(() => {
    fetchTasks();
  }, []);

  return (
    <View style={styles.container}>
      <Text style={styles.header}>Task Manager</Text>

      <TextInput
        style={styles.input}
        placeholder="Task Name"
        value={taskName}
        onChangeText={setTaskName}
      />
      <TextInput
        style={styles.input}
        placeholder="Description"
        value={description}
        onChangeText={setDescription}
      />
      <Button title="Add Task" onPress={handleAddTask} />

      <FlatList
        data={tasks}
        keyExtractor={(item) => item.id}
        style={styles.taskList}
        renderItem={({ item }) => (
          <View style={styles.taskItem}>
            <Text style={styles.taskTitle}>{item.taskName}</Text>
            <Text>{item.description}</Text>
            {!item.completed ? (
              <Button
                title="Complete"
                onPress={() => handleMarkComplete(item.id)}
              />
            ) : (
              <Text style={styles.completed}>✅ Completed</Text>
            )}
          </View>
        )}
      />
    </View>
  );
}

const styles = StyleSheet.create({
  container: { padding: 20, flex: 1, backgroundColor: "#fff" },
  header: { fontSize: 24, fontWeight: "bold", marginBottom: 20 },
  input: {
    borderWidth: 1,
    borderColor: "#aaa",
    padding: 10,
    marginBottom: 10,
    borderRadius: 5,
  },
  taskList: { marginTop: 20 },
  taskItem: {
    padding: 15,
    backgroundColor: "#f2f2f2",
    borderRadius: 8,
    marginBottom: 10,
  },
  taskTitle: { fontWeight: "bold" },
  completed: { marginTop: 5, color: "green" },
});
