class Node(object):

    def __init__(self, data):
        self.data = data
        self.left = None
        self.right = None

    def __str__(self):
        return 'Node({})'.format(self.data)

    def __eq__(self, other):
        return self.data == other.data
