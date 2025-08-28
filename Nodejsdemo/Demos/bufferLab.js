// 1. Create a Buffer of size 256 bytes
//256 is a standard size in programming, often used as a default buffer size
const buffer = Buffer.alloc(256);

// Student 1 data
const student1 = {
  id: 1,
  name: "Thananya",
  age: 20,
  grade: "A"
};

// Convert student data to JSON string
const student1Str = JSON.stringify(student1);

// 2. Write data to buffer
const bytesWritten = buffer.write(student1Str, 'utf8');

console.log(`Bytes written to buffer: ${bytesWritten}`);

// 3. Read data from buffer
const bufferContentStr = buffer.toString('utf8', 0, bytesWritten);
console.log(`Buffer content as string: ${bufferContentStr}`);

// Parse the string to object
const parsedStudent = JSON.parse(bufferContentStr);

console.log(`Parsed Student Data:`);
console.log(`ID: ${parsedStudent.id}`);
console.log(`Name: ${parsedStudent.name}`);
console.log(`Age: ${parsedStudent.age}`);
console.log(`Grade: ${parsedStudent.grade}`);

// 4. Buffer Operations

// Append another student (if space permits)
const student2 = {
  id: 2,
  name: "jash",
  age: 21,
  grade: "B"
};

const student2Str = JSON.stringify(student2);
const student2Start = bytesWritten;
const bytesWritten2 = buffer.write(student2Str, student2Start, 'utf8');

console.log(`\nAppended Student 2. Bytes written: ${bytesWritten2}`);

// Slice buffer to read only the first student
const firstStudentBuffer = buffer.slice(0, bytesWritten);
const firstStudentStr = firstStudentBuffer.toString('utf8');
console.log(`\nSliced buffer (first student): ${firstStudentStr}`);

// Copy buffer to another buffer
const copiedBuffer = Buffer.alloc(256);
firstStudentBuffer.copy(copiedBuffer, 0, 0, firstStudentBuffer.length);
console.log(`Copied buffer content: ${copiedBuffer.toString('utf8', 0, firstStudentBuffer.length)}`);

// 5. Encoding & Decoding
console.log(`\n=== Encoding Demonstration ===`);
console.log(`UTF-8: ${buffer.toString('utf8', 0, bytesWritten)}`);
console.log(`ASCII: ${buffer.toString('ascii', 0, bytesWritten)}`);
console.log(`Base64: ${buffer.toString('base64', 0, bytesWritten)}`);
