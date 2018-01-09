class Node(object):
    def __init__(self, data=None):
        self.data = data
        self.left = None
        self.right = None

    def __str__(self):
        return str(self.data)
        # return str('{}: [{}]'.format(self.data, id(self)))

    def __hash__(self):
        return id(self)

