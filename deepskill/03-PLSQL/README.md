# Module 3: PL/SQL Programming

**Status:** ✅ Successful

---

## Structure

```
03-PLSQL/
├── 01-Basics/          → basic_block.sql
├── 02-Variables/       → variables.sql
├── 03-Control-IF/      → if_else.sql
├── 04-Control-CASE/    → case_example.sql
├── 05-Loops-Basic/     → basic_loop.sql
├── 06-Loops-For/       → for_loop.sql
├── 07-Loops-While/     → while_loop.sql
├── 08-Exceptions/      → exceptions.sql
├── 09-Cursors/         → cursors.sql
├── 10-Procedures/      → procedures.sql
├── 11-Functions/       → functions.sql
├── 12-Packages/        → packages.sql
├── 13-Triggers/        → triggers.sql
└── screenshots/
```

---

## Topics Covered

| # | Topic | Description |
|---|-------|-------------|
| 1 | **Basic Block** | DECLARE-BEGIN-EXCEPTION-END structure with variables |
| 2 | **Variables** | %TYPE, %ROWTYPE, BOOLEAN, DATE, VARCHAR2, NUMBER |
| 3 | **IF/THEN/ELSE** | Conditional logic with ELSIF ladder (grade calculator) |
| 4 | **CASE** | Switch-case equivalent (day of week) |
| 5 | **Basic Loop** | LOOP-EXIT WHEN-END LOOP with counter |
| 6 | **FOR Loop** | `FOR i IN 1..5 LOOP` iteration |
| 7 | **WHILE Loop** | `WHILE condition LOOP` |
| 8 | **Exceptions** | ZERO_DIVIDE, OTHERS, user-defined exceptions, RAISE |
| 9 | **Cursors** | Explicit, FOR loop, parameterized cursors on employees table |
| 10 | **Procedures** | CREATE OR REPLACE PROCEDURE with/without params |
| 11 | **Functions** | RETURN value, calculate_bonus, get_dept_total |
| 12 | **Packages** | Package spec + body, public/private members |
| 13 | **Triggers** | BEFORE INSERT, AFTER UPDATE with :OLD/:NEW |

## Run

Run in Oracle SQL Developer, SQL*Plus, or any Oracle client:

```sql
@ "01-Basics/basic_block.sql"
@ "02-Variables/variables.sql"
@ "03-Control-IF/if_else.sql"
-- ... and so on
```

Or run all sequentially:
```sql
@ "cursors.sql"
@ "procedures.sql"
@ "functions.sql"
@ "packages.sql"
@ "triggers.sql"
```
