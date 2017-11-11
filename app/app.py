def loadData(filename):
    with open(filename, 'r') as infile:
        line = ''
        while True:
            entry = {}
            for line in infile:
                line = line.strip()
                if not line: break
            
            key, value = map(str.strip, line.split(':', 1))
            entry[key] = value
            
            yield entry


