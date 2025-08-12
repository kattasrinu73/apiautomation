## TripStax Portal – End-to-End Test Plan (Selenium + TestNG)

### Scope
Covers post-login portal functionality across core modules, cross-cutting behavior (RBAC, search/filtering, exports), and non-functional checks (basic performance, accessibility heuristics, responsiveness).

### Environments
- Staging: `https://portalstg.tripstax.com`
- Browsers: Chrome (headless default), optionally headed for debugging

### Accounts and Roles
- Primary: `user@atpi.com` / `Test@123`
- Additional: Create role-based accounts (Admin, Manager, Viewer) for RBAC validation

### High-Level Areas
- Authentication and Session Management
- Global Navigation and Layout
- Dashboard
- Trips / Records Management
- Reports and Exports
- Calculations / Statements (e.g., tax, billing)
- Files: Uploads / Downloads / Imports / Exports
- Users, Roles, Permissions (RBAC)
- Organization / Workspace context switching
- Settings & Preferences
- Notifications / Inbox
- Help / Support links
- Global Search / Filters / Pagination patterns
- Error handling, empty states, and edge cases

---

### Authentication & Session
- TC-AUTH-001: Login with valid credentials
  - Steps: Open login, enter valid, submit
  - Expected: Redirect to dashboard/home; user avatar or logout visible
- TC-AUTH-002: Invalid password
  - Expected: Inline error, stay on login
- TC-AUTH-003: Required field validation (empty email/password)
- TC-AUTH-004: Persisted session (remember me if present)
- TC-AUTH-005: Logout via menu and direct route protection
- TC-AUTH-006: Session timeout and renewal flow
- TC-AUTH-007: Password reset/forgot password flow (if exposed)
- TC-AUTH-008: MFA prompt (if enabled)

### Global Navigation & Layout
- TC-NAV-001: All primary menu links visible post-login for role
- TC-NAV-002: Navigate to each module; correct title/breadcrumb
- TC-NAV-003: Active menu highlighting matches route
- TC-NAV-004: Organization switcher changes data scope
- TC-NAV-005: Quick search opens, search-as-you-type returns results
- TC-NAV-006: Keyboard navigation for menu and modals

### Dashboard
- TC-DASH-001: Loads successfully; KPIs visible
- TC-DASH-002: Date range filter updates widgets
- TC-DASH-003: Deep links from widgets to detail pages
- TC-DASH-004: Empty state for no data windows

### List/Table Patterns (applies to Trips, Reports, Users…)
- TC-TABLE-001: Default sort order
- TC-TABLE-002: Column sorting toggles asc/desc
- TC-TABLE-003: Column visibility toggling (if available)
- TC-TABLE-004: Global search filters rows
- TC-TABLE-005: Faceted filters (status, date range, owner)
- TC-TABLE-006: Pagination next/prev and page size changes
- TC-TABLE-007: Row selection and bulk actions
- TC-TABLE-008: Sticky headers and horizontal scroll (if many columns)
- TC-TABLE-009: Export current view vs full dataset

### Trips / Records CRUD
- TC-TRIPS-001: Create new record with minimal required fields
- TC-TRIPS-002: Full create with optional fields and attachments
- TC-TRIPS-003: Field validations (format, ranges, required)
- TC-TRIPS-004: Edit existing record and verify audit/versioning
- TC-TRIPS-005: View details page shows accurate computed fields
- TC-TRIPS-006: Archive/Delete flow with confirm dialogs and undo (if available)
- TC-TRIPS-007: Bulk update actions

### Reports & Calculations
- TC-REPORTS-001: Generate report with default filters
- TC-REPORTS-002: Apply filters and regenerate; data updates
- TC-REPORTS-003: Schedule report delivery (if available)
- TC-REPORTS-004: Export formats (CSV/XLSX/PDF) and content validation
- TC-REPORTS-005: Large dataset handling and progress indicators

### Files: Uploads / Imports / Downloads
- TC-FILES-001: Download from table export; verify MIME, size > 0
- TC-FILES-002: File upload with valid file; success toast and row count
- TC-FILES-003: Invalid file type rejected gracefully
- TC-FILES-004: Import preview mapping and validation errors listed
- TC-FILES-005: Download template file (if provided)

### Users, Roles, Permissions (RBAC)
- TC-RBAC-001: Admin can access Users and Roles modules
- TC-RBAC-002: Viewer cannot access admin-only modules (HTTP 403 or redirect)
- TC-RBAC-003: Feature flags or role-based UI hiding is consistent with API
- TC-RBAC-004: Attempt restricted API action via UI yields error and no state change

### Settings & Preferences
- TC-SET-001: Update profile details; persists after reload
- TC-SET-002: Change password flow (if applicable)
- TC-SET-003: Notification preferences toggle and persist
- TC-SET-004: Localization settings; language applies across app

### Notifications / Inbox
- TC-NOTIF-001: New notification appears after triggering event
- TC-NOTIF-002: Mark-as-read updates counters
- TC-NOTIF-003: Link from notification to detail page

### Error Handling & Edge Cases
- TC-ERR-001: API error shows non-blocking toast and retry option
- TC-ERR-002: Network offline banner and recovery on reconnect
- TC-ERR-003: Empty states with helpful CTAs

### Non-Functional (basic in UI tests)
- TC-NF-001: Largest pages load under threshold (e.g., < 5s avg) headless
- TC-NF-002: Basic accessibility smoke (no obvious focus traps; alt text present on key icons)
- TC-NF-003: Responsive layout at 1536x960, 1366x768, 1024x768

---

### Suite Organization
- Smoke: AUTH, NAV, DASH basic loads
- Regression: Tables, CRUD, Reports, Files, RBAC, Settings
- Negative: Validation errors, permission denials

### Data Management
- Seed test data via UI or API stubs if available
- Isolate records with unique prefixes; clean up on teardown where feasible

### Automation Mapping
The following TestNG classes are provided as skeletons and should be bound to real selectors per module as the UI is explored:
- `AuthenticationTest`
- `NavigationTest`
- `DashboardTest`
- `TableBehaviorsTest`
- `TripsCrudTest`
- `ReportsAndExportTest`
- `FilesUploadDownloadTest`
- `RbacAccessTest`
- `SettingsPreferencesTest`
- `SessionManagementTest`
- `LocalizationResponsiveTest`

Each test contains disabled methods annotated with `enabled = false`. Enable and complete selectors once the application’s UI elements are identified.