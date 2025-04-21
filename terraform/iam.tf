resource "aws_iam_role" "inventory_task_execution_role" {
  name = "${var.app_name}-ecs-task-execution-role"

  assume_role_policy = jsonencode({
    Version   = "2012-10-17",
    Statement = [
      {
        Action    = "sts:AssumeRole",
        Effect    = "Allow",
        Principal = {
          Service = "ecs-tasks.amazonaws.com"
        }
      }
    ]
  })
}

resource "aws_iam_role_policy_attachment" "ecs_task_execution_role_policy" {
  role       = aws_iam_role.inventory_task_execution_role.name
  policy_arn = "arn:aws:iam::aws:policy/service-role/AmazonECSTaskExecutionRolePolicy"
}

resource "aws_iam_policy" "sqs_consumer_policy" {
  name        = "sqs-consumer-policy"
  description = "Permissões para consumir mensagens de uma fila SQS"

  policy = jsonencode({
    Version   = "2012-10-17",
    Statement = [
      {
        Effect = "Allow",
        Action = [
          "sqs:ReceiveMessage",
          "sqs:DeleteMessage",
          "sqs:GetQueueAttributes",
          "sqs:ChangeMessageVisibility",
          "sqs:GetQueueUrl"
        ],
        Resource = data.aws_sqs_queue.order-created-queue.arn
      },
      {
        Effect   = "Allow",
        Action   = "sqs:ListQueues",
        Resource = "*"
      }
    ]
  })
}

# Vincule a política à role
resource "aws_iam_role_policy_attachment" "ecs_sqs_attachment" {
  role       = aws_iam_role.inventory_task_execution_role.name
  policy_arn = aws_iam_policy.sqs_consumer_policy.arn
}
