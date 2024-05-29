public class LinkedList {
    Node head;

    public boolean isEmpty() {
        return (head == null);
    }

    public void print() {
        if (!isEmpty()) {
            Node currentNode = head;
            System.out.print("Isi Linked List\t\t\t: ");
            while (currentNode != null) {
                System.out.print(currentNode.data + "\t\t");
                currentNode = currentNode.next;
            }
            System.out.println("");
        } else {
            System.out.println("Linked List Kosong");
        }
    }

    public void addFirst(int input) {
        Node newNode = new Node(input, null);

        if (isEmpty()) {
            head = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
    }

    public void addLast(int input) {
        Node newNode = new Node(input, null);

        if (isEmpty()) {
            head = newNode;
        } else {
            Node currentNode = head;

            while (currentNode.next != null) {
                currentNode = currentNode.next;
            }
            currentNode.next = newNode;
        }
    }

    public void insertAfter(int key, int input) {
        Node newNode = new Node(input, null);

        if (!isEmpty()) {
            Node currentNode = head;

            do {
                if (currentNode.data == key) {
                    newNode.next = currentNode.next;
                    currentNode.next = newNode;
                    break;
                }

                currentNode = currentNode.next;

            } while (currentNode != null);
        } else {
            System.out.println("Linked list kosong");
        }
    }

    public int getData(int index) {
        Node currentNode = head;
        int currentIndex = 0;

        while (currentNode != null) {
            if (currentIndex == index) {
                return currentNode.data;
            }
            currentNode = currentNode.next;
            currentIndex++;
        }

        throw new IndexOutOfBoundsException("Indeks melebihi batas");
    }

    public int indexOf(int key) {
        Node currentNode = head;
        int index = 0;
        while (currentNode != null && currentNode.data != key) {
            currentNode = currentNode.next;
            index++;
        }
        if (currentNode == null) {
            return -1;
        } else {
            return index;
        }
    }

    public void removeFirst() {
        if (!isEmpty()) {
            head = head.next;
        } else {
            System.out.println("Linked List Kosong");
        }
    }

    public void removeLast() {
        if (isEmpty()) {
            System.out.println("Linked List Kosong");
        } else if (head.next == null) {
            head = null;
        } else {
            Node currentNode = head;
            while (currentNode.next != null) {
                if (currentNode.next.next == null) {
                    currentNode.next = null;
                    break;
                }
                currentNode = currentNode.next;
            }

        }
    }

    public void remove(int key) {
        if (isEmpty()) {
            System.out.println("Linked list kosong");
        } else if (head.data == key) {
            removeFirst();
        } else {
            Node currentNode = head;

            while (currentNode.next != null) {
                if (currentNode.next.data == key) {
                    currentNode.next = currentNode.next.next;
                    break;
                }

                currentNode = currentNode.next;
            }
        }
    }

    public void insertBefore(int key, int input) {
        Node newNode = new Node(input, null);

        if (!isEmpty()) {
            if (head.data == key) {
                newNode.next = head;
                head = newNode;
            } else {
                Node prevNode = null;
                Node currentNode = head;

                while (currentNode != null) {
                    if (currentNode.data == key) {
                        prevNode.next = newNode;
                        newNode.next = currentNode;
                        break;
                    }
                    prevNode = currentNode;
                    currentNode = currentNode.next;
                }

                if (currentNode == null) {
                    System.out.println("Keyword tidak ditemukan");
                }
            }
        } else {
            System.out.println("Linked list kosong");
        }
    }

    public void insertAt(int index, int input) {
        if (index < 0) {
            throw new IndexOutOfBoundsException("Indeks tidak boleh negatif");
        }

        Node newNode = new Node(input, null);

        if (index == 0) {
            newNode.next = head;
            head = newNode;
        } else {
            Node currentNode = head;
            for (int i = 0; i < index - 1; i++) {
                if (currentNode == null) {
                    throw new IndexOutOfBoundsException("Indeks melebihi batas");
                }
                currentNode = currentNode.next;
            }

            if (currentNode != null) {
                newNode.next = currentNode.next;
                currentNode.next = newNode;
            } else {
                throw new IndexOutOfBoundsException("Indeks melebihi batas");
            }
        }
    }

    public void removeAt(int index) {
        if (isEmpty()) {
            System.out.println("Linked list kosong");
            return;
        }

        if (index < 0) {
            throw new IndexOutOfBoundsException("Indeks tidak boleh negatif");
        }

        if (index == 0) {
            head = head.next;
        } else {
            Node prevNode = null;
            Node currentNode = head;

            for (int i = 0; i < index; i++) {
                if (currentNode == null) {
                    throw new IndexOutOfBoundsException("Indeks melebihi batas");
                }
                prevNode = currentNode;
                currentNode = currentNode.next;
            }

            if (currentNode == null) {
                throw new IndexOutOfBoundsException("Indeks melebihi batas");
            }

            prevNode.next = currentNode.next;
        }
    }

}
